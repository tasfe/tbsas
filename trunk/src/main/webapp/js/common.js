/********************************************************** 以下都是直供机移植过来的函数 *********************************************************/
//图片地址
var PHOTO_URL="";
//var TERMINAL_URL="http://wwwdev.100gong.tk/service100gonghost";//订单流程服务器URL
var TERMINAL_URL="";//订单流程服务器URL
/***************************************************************common说明开始**************************************************/
//所有以下划线"_"开始的函数都是不支持外面调用的
/***************************************************************common说明结束**************************************************/
//排序函数
function sortNum(a,b){
	return (parseInt(a)>parseInt(b)?1:-1);
}
function sortPersent(a,b){
	a=parseInt(a.slice(0,-1));
	b=parseInt(b.slice(0,-1));
	return (a>b?1:-1);
}
/***************************************************************common开发配置开始**************************************************/
//主体.顶级域名,方便于跨子域访问
var stUrlReg=/[^\.]*?\.com\.cn|[^\.]*?\.net\.cn|[^\.]*?\.org\.cn|[^\.]*?\.edu\.cn|[^\.]*?\.com|[^\.]*?\.cn|[^\.]*?\.net|[^\.]*?\.org|[^\.]*?\.edu|[^\.]*?\.tk/i;
var stCrossAreaJqueryObject={};
var sBaseAreaName=window.location.host.toLowerCase().match(stUrlReg)[0];
//代理文件路径
//document.domain=sBaseAreaName;
/***************************************************************common开发配置结束**************************************************/
/***************************************************************ajax跨域打包开始**************************************************/
function ajax(stAjaxOB)
{	stAjaxOB.url=$.trim(stAjaxOB.url);
	stAjaxOB.waitTagId=$.trim(stAjaxOB.waitTagId);
	if(stAjaxOB.url=='')
	{
		alert('url不能为空!');
		return;
	}
	//加载等待图片
	if(typeof(stAjaxOB.waitTagId)!='undefined'&&stAjaxOB.waitTagId!='')
	{	var sTime=(new Date()).getTime();
		var stIDOB=document.getElementById(stAjaxOB.waitTagId);
		if(!stIDOB)stIDOB=document.body;
		var stPosition=getElementPosition(stIDOB);
		//等待图片为32*32的格式，所以要减去16
		var iTop=stPosition.top+stIDOB.offsetHeight/2-16;
		var iLeft=stPosition.left+stIDOB.offsetWidth/2-16;
		var sImg='<img id="WaitImg'+sTime+'" style="border:0;position:';
		if(stIDOB.tagName.toLowerCase()=="body")sImg+="fixed";
		else sImg+="absolute";
		sImg+=';_position:absolute;top:'+iTop+'px;left:'+iLeft+'px" src="/images/module/loadingAnimation.gif"/>';
		stAjaxOB.waitPicId="WaitImg"+sTime;
		$("body").append(sImg);
	}
	////拼凑error,success字符串形式的函数
	var sSuccessFun='stAjaxOB.success(';
	var sErrorFun='stAjaxOB.error(';
	var stParamStr=[];
	var stParam={};
	stParamStr.push('data');
	//设置error,success除了data以外的参数
	for(var i=1,iLength=arguments.length;i<iLength;i++)
	{	stParam[i]=arguments[i];
		stParamStr.push('stParam['+i+']');
	}
	sSuccessFun+=stParamStr.join(',');
	sSuccessFun+=')';
	sErrorFun+=stParamStr.join(',');
	sErrorFun+=')';
	var sAccessUrl=stAjaxOB.url;
	var sAccessUrl=sAccessUrl.toLowerCase().replace(/http(s)?\:\/\/|\s/ig,"");
	//获取端口号
	var stPort=sAccessUrl.match(/:\d+/g);
	sAccessUrl=sAccessUrl.replace(/:\d+/g,'');
	var sLocalUrl=window.location.host.toLowerCase().replace(/http(s)?\:\/\/|\s/ig,'');	
	var sLocalPort=$.trim(window.location.port);
	var sAccessPort=$.trim(stPort&&stPort[0]?stPort[0].replace(/:/g,''):'');
	if(sAccessPort=='80')sAccessPort='';
	
	if(sAccessUrl.indexOf(sBaseAreaName)!=-1)
	{	var sAccessUrlIndex=sAccessUrl.indexOf("/");
		//访问的url刚好是"主体.顶级域名"格式
		if(sAccessUrlIndex==-1)sAccessUrlIndex=sAccessUrl.length;
		sAccessUrl=sAccessUrl.substring(0,sAccessUrlIndex);	
		//这种"主体.顶级域名"格式,子域名为空
		var stReg=new RegExp("(\.)?"+sBaseAreaName,"ig");
		var sAccessArea=sAccessUrl.replace(stReg,"");
		var sLocalArea=sLocalUrl.replace(stReg,"");
		if(sAccessArea!=sLocalArea||sLocalPort!=sAccessPort)
		{	//使用缓存中跨域的Jquery对象
			if(stCrossAreaJqueryObject[sAccessArea+':'+sAccessPort]){
				_doAjax(stCrossAreaJqueryObject[sAccessArea+':'+sAccessPort],stAjaxOB,stParam,sSuccessFun,sErrorFun,null);
				return;
			}
			
			//判断域是否相同,不同的域需要Iframe配合
			//Iframe配合,一定要同步
			stAjaxOB.async=false;
			var sSrc='';
			if(sAccessArea=='')
			{
				sSrc='http://'+sBaseAreaName;
				if(sAccessPort!='')sSrc+=stPort[0];
				sSrc+='/proxy.html';
			}
			else
			{
				sSrc='http://'+sAccessArea+'.'+sBaseAreaName;
				if(sAccessPort!='')sSrc+=stPort[0];
				sSrc+='/proxy.html';
			}
			//创建iframe  
			var proxy=document.createElement("iframe");  
			proxy.src=sSrc; 
			proxy.style.display="none"; 
			proxy.stAjaxOB=stAjaxOB;
			proxy.stParam=stParam;
			proxy.sSuccessFun=sSuccessFun;
			proxy.sErrorFun=sErrorFun;
			//IE这样设置box.onload无效
			if(proxy.attachEvent)
			{
				proxy.attachEvent('onload',function(){
				    //缓存跨域的Jquery对象
					stCrossAreaJqueryObject[sAccessArea+':'+sAccessPort]=proxy.contentWindow.$;									
					_doAjax(proxy.contentWindow.$,proxy.stAjaxOB,proxy.stParam,proxy.sSuccessFun,proxy.sErrorFun,proxy);
				});
			}
			else
			{	
				proxy.onload=function(){
					//缓存跨域的Jquery对象
					stCrossAreaJqueryObject[sAccessArea+':'+sAccessPort]=this.contentWindow.$;	
					_doAjax(this.contentWindow.$,this.stAjaxOB,this.stParam,this.sSuccessFun,this.sErrorFun,this);
				}
			}
			$("body").append(proxy);
		}
		else
		{
			//相同域名
			_doAjax($,stAjaxOB,stParam,sSuccessFun,sErrorFun,null);	
		}		
	}
	else
	{
		//使用的是相对路径
		_doAjax($,stAjaxOB,stParam,sSuccessFun,sErrorFun,null);
	}
}
//二级函数,不能直接调用
function _doAjax(stJquery,stAjaxOB,stParam,sSuccessFun,sErrorFun,stIframe)
{	//存储本区域的window对象
	var localWindow=window;
	stJquery.ajax({ 
		url:typeof(stAjaxOB.url)!='undefined'?stAjaxOB.url:'',
		type:typeof(stAjaxOB.type)!='undefined'?stAjaxOB.type:'get',
		data:typeof(stAjaxOB.data)!='undefined'?stAjaxOB.data:'',
		dataType:typeof(stAjaxOB.dataType)!='undefined'?stAjaxOB.dataType:'text',
		async:typeof(stAjaxOB.async)!='undefined'?stAjaxOB.async:true,
		cache:typeof(stAjaxOB.cache)!='undefined'?stAjaxOB.cache:false,
		timeout:typeof(stAjaxOB.timeout)!='undefined'?stAjaxOB.timeout:30000,
		error:function(data){
			if(typeof(stAjaxOB.error)!='undefined')eval(sErrorFun);
			/*if(stIframe){
				setTimeout(function(){
					$(stIframe).remove();
				},1000);
			}*/
			if(typeof(stAjaxOB.waitPicId)!='undefined')$("#"+stAjaxOB.waitPicId).remove();
		}, 
		success:function(data)
		{	if(typeof(stAjaxOB.success)!='undefined')eval(sSuccessFun);
			/*if(stIframe){
				setTimeout(function(){
					$(stIframe).remove();
				},1000);
			}*/
			if(typeof(stAjaxOB.waitPicId)!='undefined')$("#"+stAjaxOB.waitPicId).remove();
		}
	})	
}
/***************************************************************ajax跨域打包结束**************************************************/
function toFloat(num,len){
	len=len||2;
	return num.toFixed(len);
}
function trim(sStr){
	if(typeof(sStr)!='string')return sStr;
	return sStr.replace(/(^\s*)|(\s*$)/g,"");
}