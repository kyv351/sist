function init(){
	var btnSum = document.getElementById("btn-sum");
	btnSum.onclick = btnSumClick;	
}

function btnSumClick(){
	var x = document.getElementById("txt-x");
	var y = document.getElementById("txt-y");
	
	var sum = parseInt(x.value) + parseInt(y.value);
	
	
	document.getElementById("txt-sum").value = sum;
	
	
}

window.onload=init;