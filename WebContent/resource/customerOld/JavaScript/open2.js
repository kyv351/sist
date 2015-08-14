function btnResizeClick(){
	/*opener는 open함수를 통해서 open된것*/
	opener.resizeTo(100, 100);
}

function btnMoveClick(){
	opener.moveTo(100, 100);
	
}

function btnOpenerClick(){
	opener.close();
}

window.addEventListener("load", function(){
	var btnResize = document.getElementById("btn-resize");
	var btnMove = document.getElementById("btn-move");
	var btnOpenerClose = document.getElementById("btn-opener-close");
	
	btnResize.onclick=btnResizeClick;
	btnMove.onclick=btnMoveClick;
	btnOpenerClose.onclick=btnOpenerClick;}
)