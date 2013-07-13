
/* 设为首页 */
function setHomePage(url){
	if (document.all) {
		document.body.style.behavior = "url(#default#homepage)";
		document.body.setHomePage(url);
	} else if (window.sidebar) {
		if (window.netscape) {
			try {
				netscape.security.PrivilegeManager
						.enablePrivilege("UniversalXPConnect");
			} catch (e) {
				alert("此操作被浏览器拒绝！\n请在浏览器地址栏输入“about:config”并回车\n然后将 [signed.applets.codebase_principal_support]的值设置为'true',双击即可。");
				return false;
			}
		}
		var prefs = Components.classes["@mozilla.org/preferences-service;1"]
				.getService(Components.interfaces.nsIPrefBranch);
		prefs.setCharPref('browser.startup.homepage', url);
	} else {
		// alert('您的浏览器不支持自动设置首页,
		// 使用浏览器菜单或在浏览器地址栏输入"chrome://settings/browser"手动设置!');
	}
	return false;
}
/* 添加收藏 */
function addFavorites(){
	var ctrl = (navigator.userAgent.toLowerCase()).indexOf('mac') != -1? 'Command/Cmd': 'CTRL';
	if (document.all) {
		window.external.addFavorite('http://www.100gong.cn', '佰供');
	} else if (window.sidebar) {
		window.sidebar.addPanel('佰供', 'http://www.100gong.cn', "");
	} else {// 添加收藏的快捷键
		alert('添加失败\n您可以尝试通过快捷键' + ctrl + ' + D 加入到收藏夹~');
	}
}

/*$(document).ready(function() {
	$(".main .img img").lazyload({
				placeholder : '/images/module/blank.gif',
				effect : "fadeIn",
				failurelimit : 30
			});
});*/
function loadHtml(headerId,sUrl,async){
	if(!async)async=false;
	ajax({
		url:sUrl,
		type:"get",
		dateType:"html",
		async:async,
		success:function(html){
			$("#"+headerId).html(html);
		}
	});
};
//判断是否是IE
function isIE(){
	var arVersion = navigator.appVersion.split("MSIE");
    var version = parseFloat(arVersion[1])
    if ((version > 5.5))return version;
	else return false;
}
//得到元素实际坐标
function getElementPosition(OB)
{	var posX=OB.offsetLeft;
	var posY=OB.offsetTop;
	var aBox=OB;//需要获得位置的对象
	while(aBox.tagName.toLowerCase()!="body")
	{	aBox=aBox.offsetParent;
		posX+=aBox.offsetLeft;
		posY+=aBox.offsetTop;
	}
	return {left:posX,top:posY};
}
//获取url参数
function getUrlParam(sName)
{	
	if(sName)
	{
		var sValue='';
		var re= new RegExp(sName+"=([^&=]+)");
		var st=null;
		st=window.location.search.match(re);
		if(st&&st.length==2)
		{	
			st[1]=st[1].replace(/^\s*|\s*$/g,'');
			sValue=st[1];
		}
		return sValue
	}
	else
	{
		alert("参数不能为空");
		return false;
	}
}
function locationHref(url,target){
	//可以支持多种跳转方式，而且document.referrer做记录
	target=target?target:'_self';
	var a=document.createElement("a");
	a.style.display='none';
	a.href=url;
	a.target=target;
	a.innerHTML='&nbsp;';
	document.body.appendChild(a);
	a.click();
	if(target!='_self')document.body.removeChild(a);
}
//清除文本框提示信息
function inputOnFocus(ob){
	var sib=ob.previousSibling;
	if(!sib||sib.nodeName.toLowerCase()!='label')return;
	$(sib).hide();
}
function inputOnBlur(ob){
	var sib=ob.previousSibling;
	if(!sib||sib.nodeName.toLowerCase()!='label')return;
	var val=$.trim(ob.value);
	if(val=='')$(sib).show();
	else $(sib).hide();
}
/**************************************************** 设置cookie **********************************************/
function getCookie(name){
	var start=document.cookie.indexOf(name+"=");
	if(start==-1) return null;
	var len=start + name.length + 1;
	var end = document.cookie.indexOf(';',len);
	if (end==-1) end=document.cookie.length;
	return unescape(document.cookie.substring(len, end));
}
function setCookie(name,value,expires){
	if(expires){
		expires=expires*1000*60*60*24;
		var today = new Date();
		expires = new Date(today.getTime()+(expires));
		expires = 'expires='+expires.toGMTString();
	}else expires = '';
	value = escape(value);
	//sBaseAreaName来自common.js
	document.cookie = name+'='+value+';path=/;domain='+sBaseAreaName+';'+expires;
}
function deleteCookie(name){
	//sBaseAreaName来自common.js
	document.cookie = name+'=;path=/;domain='+sBaseAreaName+';expires=Thu, 01-Jan-1970 00:00:01 GMT'; 
}
//判断用户是否登录
function isUserLogin(){
	var _lngd=getCookie('_lngd');
	var _usergd=getCookie('_usergd');
	var _lplatformgd=getCookie('_lplatformgd');
	if(_lngd==null)_lngd='';
	if(_usergd==null)_usergd='';
	if(_lplatformgd==null)_lplatformgd='';
	_lngd=$.trim(_lngd);
	_usergd=$.trim(_usergd);
	if(_lngd==''||_usergd==''||_lplatformgd==''||_lplatformgd!=413)return false;
	else return true;	
}
//得到当前时间,stDate是日期对象，iDay当前日期对象偏移的天数，long是否显示小时，分钟,秒
function GetTime(stDate,iDay,long)
{	var alldate="";
	var dt=null;
	if(stDate)dt=stDate;
	else dt=new Date();
	dt.setDate(dt.getDate()+iDay);
	var sYear=dt.getFullYear();
	var sMonth=dt.getMonth();
	sMonth++;
	if(sMonth<=9)sMonth="0"+sMonth;
	var sDay=dt.getDate();
	if(sDay<=9)sDay="0"+sDay;
	if(!long)
	{
		alldate=sYear+"-"+sMonth+"-"+sDay;
	}
	else
	{
		var sHours=dt.getHours();
		if(sHours<=9)sHours="0"+sHours;
		var sMinutes=dt.getMinutes();
		if(sMinutes<=9)sMinutes="0"+sMinutes;
		var sSeconds=dt.getSeconds();
		if(sSeconds<=9)sSeconds="0"+sSeconds;
		alldate=sYear+"-"+sMonth+"-"+sDay+' '+sHours+':'+sMinutes+':'+sSeconds;
	}
	return alldate;
}
/******************************************************* 购物车 ********************************************************/
var card_cookie = 'cn.digione.cart'; // 存储的cookie的 key
// 添加产品到购物车
function addCartCookie(productId, quantity) {
	if (getCookie(card_cookie) == null)setCookie(card_cookie,'[]',30);
	var cart = JSON.parse(getCookie(card_cookie));
	var flag = false;
	for (var i = 0, length=cart.length; i < length; i++) {
		if (cart[i].productId == productId) {
			var total = parseInt(cart[i].quantity) + parseInt(quantity);
			if (total < 0) {
				alert('您输入的数字已经超出最小值');
				return;
			}
			cart[i].quantity = total;
			flag = true;
			break;
		}
	}
	// 如果购物车中没有此产品，则添加到购物车
	if (!flag) {
		cart[cart.length] = {
			"productId" : productId,
			"quantity" : quantity,
			"isAfterser" : "0",
			"afterserPrice" : 0
		};// 增加isafterser属性：售后由公司承担，默认为否：0表示,afterserPrice属性：费用
	}
	setCookie(card_cookie,JSON.stringify(cart),30);
}
//删除购物车中的产品
function removeCardCookie(productId) {
	var cart = JSON.parse(getCookie(card_cookie));
	for (var i = 0, length=cart.length; i < length; i++) {
		if (cart[i].productId == parseInt(productId)) {
			cart.splice(i, 1);
			setCookie(card_cookie,JSON.stringify(cart),30);
			break;
		}
	}
}
//得到购物车的产品数量
function getCardCookieQuantity(){
	var quantity = 0;
	if (getCookie(card_cookie) != null) {
		var cart = JSON.parse(getCookie(card_cookie));
		for (var i = 0, length=cart.length; i < length; i++) {
			quantity += parseInt(cart[i].quantity);
		}
	}
	return quantity;
}
// 清空购物车
function cleanCartCookie() {
	deleteCookie(card_cookie);
}
/************************************************************* 修正浏览器JSON对象 *******************************************************/
//JSON其实就是高级浏览器的一个window.JSON,低于IE8是没有JSON对象的,大家注意啦不要乱使用
if(typeof(JSON)=='undefined')JSON={};
if(!JSON.parse)JSON.parse=function(str){
	var json = (new Function("return " + str))();
	return json;	
}
if(!JSON.stringify)JSON.stringify=function(obj){
	switch(typeof(obj)){
		case 'string':
			return '"' + obj.replace(/(["\\])/g, '\\$1') + '"';
		case 'array':
			return '[' + obj.map(arguments.callee).join(',') + ']';
		case 'object':
			 if(obj instanceof Array){
				var strArr = [];
				var len = obj.length;
				for(var i=0; i<len; i++){
					strArr.push(arguments.callee(obj[i]));
				}
				return '[' + strArr.join(',') + ']';
			}else if(obj==null){
				return 'null';

			}else{
				var string = [];
				for (var property in obj) string.push(arguments.callee(property) + ':' + arguments.callee(obj[property]));
				return '{' + string.join(',') + '}';
			}
		case 'number':
			return obj;
		case false:
			return obj;
	}
}
/************************************************************** 自定义弹框 *************************************************************/
/*showBox('内标签','footerId')
showBox('自定义文本','你好我是自定义文本')
showBox('显示Iframe','/index.html?width=500&height=300')
showBox('显示AjaxHTML','/include/header.html?ajax')
showBox('alert框','用户不存在','alert',function(){alert('执行自定义函数')})
showBox('confirm框','用户不存在','confirm',function(){alert('执行自定义函数')})*/
function showBox(title,param,winType,callBack){
	title=trim(title);
	param=trim(param);
	addBoxIE6Css();
	var id=(new Date()).getTime();
	var html=[];
	html.push('<table cellpadding="0" cellspacing="0" width="100%" height="100%" class="showBox" id="showBox');
	html.push(id);
	html.push('" style="z-index:');
	html.push(id);
	html.push('"><tr><td align="center" valign="middle"  style="width:100%;height:100%">');
	/************************* 添加css Begin *************************/
	html.push('<style type="text/css">');
	html.push('.showBox{position:fixed;_position:absolute;top:0px;left:0px}.box_overlay{position:fixed;_position:absolute;top:0;left:0;width:100%;height:100%;background:#000;filter:alpha(opacity=50);-moz-opacity:0.50;opacity:0.50;}');
	html.push('.box_main{border:1px solid #cbcaca;text-align:left;background-color:#fff;position:relative;top:0;left:0}');
	html.push('.box_title{font-size:14px;font-weight:700;overflow:hidden;}');
	html.push('.box_title .text{padding-left:10px;height:36px;line-height:36px;}');
	html.push('.box_title .close_box{ text-align:right;padding-right:10px;}');
	html.push('.box_title .close{display:inline-block;width:20px;height:36px;background:url(/images/module/icon_close.gif) no-repeat 0 center;overflow:hidden;cursor:pointer;}');
	html.push('.box_content{border-top:1px solid #b20c00;}');
	html.push('.box_txt{padding:10px;}');
	html.push('.box_btn{padding:0 0 6px;text-align:center;}');
	html.push('.box_btn button{width:74px;height:34px;margin:0 3px;border:0;cursor:pointer;background:url(/images/module/showbox_btn.gif) no-repeat}');
	html.push('.box_btn button.no{background-position:-76px 0}');
	html.push('.box_ie6_html{height:100%;_overflow:hidden}');
	html.push('.box_ie6_body{height:100%;_overflow:auto;margin:0}');
	html.push('</style>');
	/************************* 添加css End *************************/
	html.push('<div class="box_overlay"></div><table id="box_main');
	html.push(id);
	html.push('" class="box_main"><tr class="box_title"><td class="text">');
	html.push(title);
	html.push('</td><td class="close_box">');
	var isAddCloseButton=true;
	if(typeof(winType)!='undefined'){
		winType=trim(winType.toLowerCase());
		if(winType=='alert'||winType=='confirm')isAddCloseButton=false;
	}
	if(isAddCloseButton){
		html.push('<span class="close" onclick="closeBox(');
		html.push(id);
		html.push(');"></span>');
	}
	html.push('</td></tr><tr><td id="box_content');
	html.push(id);
	html.push('" colspan="2" class="box_content">');
	var isAjaxHTML=false;
	var isInnerHTML=false;
	var innerHTML='';
	var element=null;
	if(param&&param.nodeType==1)element=param;
	else element=document.getElementById(param);
	if(element){
		isInnerHTML=true;
		innerHTML=element.innerHTML;
		element.innerHTML='';
		html.push(innerHTML);	
	}
	else if(/^[^<>]*?\.(html|htm|jsp)[^<>]*$/i.test(param)){
		//xxxxx.html?width=xxx&height=xxx
		if(/\?[^&=\?]*?ajax/i.test(param)){
			isAjaxHTML=true;	
		}else{
			var width='';
			var height='';
			var stWidth=param.match(/width=([0-9%]+)/i);
			if(stWidth&&stWidth.length)width=stWidth[1];
			var stHeight=param.match(/height=([0-9%]+)/i);
			if(stHeight&&stHeight.length)height=stHeight[1];
			if(param.indexOf('?')==-1)param+='?boxId='+id;
			else param+='&boxId='+id;
			html.push('<iframe frameborder="0" marginheight="0" marginwidth="0" ');
			if(width!='') {html.push('width="'+width+'"');}
			if(height!='') {html.push(' height="'+height+'"');}
			html.push(' src="'+param+'"></iframe>');
		}
	}
	else{
		html.push('<div class="box_txt">'+param+'</div>');	
	}
	html.push('</td></tr><tr style="display:none"><td colspan="2" class="box_btn" id="box_btn');
	html.push(id);
	html.push('"></td></tr></table></td></tr></table>');
	var div=document.createElement('div');
	div.innerHTML=html.join('');
	document.body.appendChild(div.firstChild);
	//插入内标签缓存内容
	if(isInnerHTML){
		var input=document.createElement('input');
		input.innerDom=element;
		input.id="box_InnerTag"+id;
		input.type='hidden';
		input.value=innerHTML;
		document.getElementById("box_content"+id).appendChild(input);
	}
	if(isAjaxHTML&&loadHtml)loadHtml('box_content'+id,param);
	if(typeof(winType)!='undefined'){
		winType=trim(winType.toLowerCase());
		if(winType=='alert'||winType=='confirm'){
			var oBtn1=document.createElement('button');
			oBtn1.className="yes"; 
			oBtn1.onclick=function(){
				closeBox(id);
				if(typeof(callBack)!="undefined"){callBack()};
			}
			var buttonBox=document.getElementById("box_btn"+id);
			buttonBox.parentNode.style.display="";
			buttonBox.appendChild(oBtn1);
			if(winType=='confirm'){
				var oBtn2=document.createElement('button');
				oBtn2.className="no";
				oBtn2.onclick=function(){
					closeBox(id);
				}
				buttonBox.appendChild(oBtn2);
			}
		}	
	}
	var main=document.getElementById('box_main'+id);
	var width=main.offsetWidth;
	var height=main.offsetHeight;
	if(width<250)main.style.width='250px';
	if(height<100)main.style.height='100px';
}
function addBoxIE6Css(){
	if(isIE()){
		var html=document.documentElement;
		var body=document.body;
		var htmlClass=trim(html.className.replace(/box_ie6_html/g,''));
		var bodyClass=trim(body.className.replace(/box_ie6_body/g,''));
		if(htmlClass!='')htmlClass+' box_ie6_html';
		else htmlClass='box_ie6_html'; 
		if(bodyClass!='')bodyClass+' box_ie6_body';
		else bodyClass='box_ie6_body';
		html.className=htmlClass;
		body.className=bodyClass;
	}	
}
function removeBoxIE6Css(){
	if(isIE()){
		var html=document.documentElement;
		var body=document.body;
		var htmlClass=trim(html.className.replace(/box_ie6_html/g,''));
		var bodyClass=trim(body.className.replace(/box_ie6_body/g,''));
		html.className=htmlClass;
		body.className=bodyClass;
	}	
}
function closeBox(id){
	removeBoxIE6Css();
	//如果没有传id,关闭的将是最近的打开的showBox
	if(typeof(id)=='undefined'){
		var stTable=document.getElementsByTagName('table');
		for(var i=0,length=stTable.length;i<length;i++){
			if(stTable[i].className=='showBox'){
				id=stTable[i].id.replace(/\D/g,'');
			}
		}	
	}
	if(typeof(id)=='undefined')return;
	//还原内标签
	var input=document.getElementById("box_InnerTag"+id);
	if(input){
		var innerTag=input.innerDom;
		if(innerTag)innerTag.innerHTML=input.value;
	}
	document.body.removeChild(document.getElementById('showBox'+id));
}