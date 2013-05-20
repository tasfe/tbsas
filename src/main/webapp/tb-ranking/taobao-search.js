// 卖家旺旺ID
var sellIds = ["lzc3144", "s小人物"];


function findInfo() {
	var info = null;
	
	$(".list-item, .item").each(function() {
		var seller = $(this).find(".seller").children("a").text();
		if(sellIds.contains(seller)) {
			var at = $(this).find(".summary").children("a");
			alert(at.attr("href"));
			info = $(this);
		}
		else {
			nextPage();
			return findInfo();
		}
	});
	
	return info;
}


function nextPage() {
	$(".page-siblings").children("a")[0].click();
}


Array.prototype.contains = function(e) {
	for(i = 0; i < this.length; i++) {
		if(this[i] == e) {
			return true;
		}
	}
	return false;
}

var pageUp = function() {
	var $wd = $(window);
	$wd.scrollTop($wd.scrollTop() - 5);
}

var pageDown = function() {
	$wd = $(window);
	$wd.scrollTop($wd.scrollTop() + 5);
}