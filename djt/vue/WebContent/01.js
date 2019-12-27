//定义一个函数
function Vue(options) {
	//定义根节点信息  获取这个节点的参数信息
	var rootElement=options.el;
	//document.获取节点信息rootElement id
	var div = document.getElementById(rootElement);
	//设置样式的backgroundColor元素对象的背景颜色
	div.style.backgroundColor="#FF0000";
}
//2.用框架
try {
	//var一个参数
	var options={"el":"app"};
	//创建Vue对象,把参数传进去
	var vue =new Vue(options);
} catch (e) {
	console.log(e);
}