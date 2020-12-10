jQuery.fn.menu=function(opciones){
	var estilos={
		li:{
			"border":"1px solid #444444",
			"float":"left",
			"list-style-type":"none",
			"font-family":"Arial, Helvetica, sans-serif",
			"font-size":"12px",
			"padding":"5px",
			"height":"15px",
			"display":"block",
			"width":"100px",
			"text-align":"center",
			"background-color": "#EEE",
			"color":"#444444"
		},
		normalMenu:{
			"color":"white",
			"background-color": "#333"
		},
		selectedMenu:{
			"background-color": "#EEE",
			"color":"#444444"
		},
		normalA:{
			"color":"white",
			"text-decoration":"none"
		},
		selectedA:{
			"color":"#444444"
		}
	};
	jQuery.extend(estilos, opciones);
	this.each(function(){
		$(this).children("li").css(estilos.li);
		$(this).children("li").children("a").parent("li").css(estilos.normalMenu);
		$(this).children("li").children("a").css(estilos.normalA);
		$(this).children("li").children("a").mouseenter(function(){
				$(this).parent("li").css(estilos.selectedMenu);
				$(this).css(estilos.selectedA);
		});
		$(this).children("li").children("a").mouseleave(function(){
				$(this).parent("li").css(estilos.normalMenu);
				$(this).css(estilos.normalA);
		});
	});
	return this;
}