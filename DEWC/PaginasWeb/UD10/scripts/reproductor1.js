var maxin, mmedia, play, bar, progress, mute, volume, loop;
function iniciar() {
	maxim=400;
	mmedia=document.getElementById('mmedia');
	play=document.getElementById('play');
	bar=document.getElementById('barra');
	progress=document.getElementById('progreso');
	mute=document.getElementById('mute');
	volume=document.getElementById('volume');
	play.addEventListener('click', push);
	mute.addEventListener('click', sound);
	volume.addEventListener('change', level);
	bar.addEventListener('click', move);
}
function push(){
	if(!mmedia.paused && !mmedia.ended) {
		mmedia.pause();
		play.value='Reproducir';
		clearInterval(loop);
	}else{
		mmedia.play();
		play.value='Pausa';
		loop=setInterval(status, 1000);
	}
}
function status(){
	if(!mmedia.ended){
		var size=parseInt(mmedia.currentTime*maxim/mmedia.duration);
		progress.style.width=size+'px';
	}else{
		progress.style.width='0px';
		play.innerHTML='Reproducir';
		clearInterval(loop);
	}
}
function move(e){
	if(!mmedia.paused && !mmedia.ended){
		var mouseX=e.pageX-barra.offsetLeft;
		var newtime=mouseX*mmedia.duration/maxim;
		mmedia.currentTime=newtime;
		progress.style.width=mouseX+'px';
	}
}
function sound(){
	if (mute.value=='Silencio'){
		mmedia.muted=true;
		mute.value='Sonido';
	}else{
		mmedia.muted=false;
		mute.value='Silencio';
	}
}
function level(){
	mmedia.volume=volume.value;
}
window.addEventListener('load', iniciar);