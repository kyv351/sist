var timerID=null;

function init(){
	var btnCountdown = document.getElementById("btn-countdown");
	btnCountdown.onclick = btnCountdownClick;
}

function count(){
	var lblCount = document.getElementById("lbl-count");	
	var count = parseInt(lblCount.innerText);
	
	if(count > 0)
		lblCount.innerText = --count;
	else{
		clearInterval(timerID);
		timerID = null;
	}
}

function btnCountdownClick(){	
	//count();//바로 호출
	//1초 후에 호출 : 1000ms
	//setTimeout(count,2000); 2초 후에
	if(timerID==null)
		timerID = setInterval(count, 1000);//1초마다
}


window.onload=init;