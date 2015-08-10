var win = null;

function btnNewTabClick(){
	/*win = open("open2.html");*/
	win = open("http://www.naver.com","_blank");
}

function btnNewWinClick(){
	win=open("open2.html","_blank","width=500px, height=400px");
	/*win = open("notice.html","_blank","width=500px, height=400px");*/
}

function btnCloseWinClick(){
	win.close();
	/*window.close(); 현재 창을 닫겠냐고 물어본다. explorer에서만 chrome에서는 no*/
}


window.addEventListener("load", function(){
			var btnNewTab = document.getElementById("btn-new-tab");
			var btnNewWin = document.getElementById("btn-new-win");
			var btnCloseWin = document.getElementById("btn-close-win");
			
			btnNewTab.onclick = btnNewTabClick;
			btnNewWin.onclick = btnNewWinClick;
			btnCloseWin.onclick = btnCloseWinClick;}
)

