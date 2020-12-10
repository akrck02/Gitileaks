jQuery.fn.galeria=function(opciones){
	var conf={
		ancho:"500",
		alto:"500"
	};
	jQuery.extend(conf, opciones);
	var izquierda=$(document).outerWidth();
	var arriba=$(document).outerHeight();
	izquierda=(izquierda/2)-(conf.ancho/2);
	arriba=(arriba/2)-((parseInt(conf.alto)+72)/2);
	var estilos={
		cssCaja:{
			  position:"absolute",
			  width:conf.ancho +"px",
			  height: parseInt(conf.alto)+72 +"px",
			  margin: "0 auto",
			  top:arriba +"px",
			  left:izquierda+"px"
		},
		cssDivimagen:{
			float:"right",
			clear:"both"
		},
		cssDivcerrar:{
			float:"right", 
			clear:"both"
		},
		cssDivsiguiente:{
			float:"right" 
		},
		cssDivanterior:{
			float:"left" 
		},
		cssImagen:{
			width:conf.ancho,
			height:conf.alto
		}
	};
	var imagenes=new Array();
	var i=0;
	var indice;
	
	this.each(function(){
		imagenes[i]=$(this).attr("src");
		i++;
		$(this).click(abrirImagen);
	});
	function abrirImagen(evento){
		$("<div id='caja'><div  id='divcerrar' ><img id='cerrar' src='images/close.png'/></div><div id='divimagen'><img id='imagen'  /></div><div id='divanterior'><img id='anterior' src='images/prev.png' /></div><div id='divsiguiente' ><img id='siguiente' src='images/next.png' /></div></div>").appendTo("body");
		$("#caja").css(estilos.cssCaja);
		$("#divimagen").css(estilos.cssDivimagen);
		$("#imagen").css(estilos.cssImagen);
		$("#divcerrar").css(estilos.cssDivcerrar);
		$("#divsiguiente").css(estilos.cssDivsiguiente);
		$("#divanterior").css(estilos.cssDivanterior);
		for (var i=0;i<imagenes.length;i++){
			if (imagenes[i]==$(this).attr("src")){
				indice=i;
				break;
			};
		};
		var numero=imagenes.length;
		$("#imagen").attr("src",$(this).attr("src"));
		$("#cerrar").click(function(evento){
			$("#caja").remove();
		});
		$("#siguiente").click(function(evento){
			if (indice==imagenes.length-1){
				indice=0;
			}else{
				indice++;
			};
			$("#imagen").attr("src",imagenes[indice]);
		});
		$("#anterior").click(function(evento){
			if (indice==0){
				indice=imagenes.length-1;
			}else{
				indice--;
			};
			$("#imagen").attr("src",imagenes[indice]);
		});
	};
	return this;
};