/* 	var x;
	alert(x == undefined);  
	
	var record = {kor:30, eng:70, math:80};
	alert(record.kor); 
	
	var lottos = [5,["hello","gy"], 10, 21];
	alert(lottos[1][0]); 
	 
	var members = [
	           	{uid: "newlec", name:"뉴렉"},
	           	{uid:"gy", name:"helloGY"}
	           ];
	 alert(members[1].uid);
	 
	 alert("32" > "4");  */
	
/* 	var x, y;
	x = prompt("x 값을 입력하세요",0);
	y = prompt("y 값을 입력하세요",0);
	alert(typeof x);
	
	x = parseInt(x);
	y = parseInt(y);
	alert(typeof x);
	alert(x+y); */
	
	/* var ar = ["jw" , "sh", "di","yj" ,"sy","gy"];
	for(var i in ar)
		alert(ar[i]); */
	
/* 	var m = {name:"gy", age:"25"};
	alert(m.name); alert(m['name']);
	alert(m.age); alert(m['age']);
	
	for(var k in m)
		alert(m[k]); */
		
 /*  0805 function 수업 */  
  /* alert((function(a,b) {
	      return a+b;
	   })(3,4)); */
	    

	   /*  function add(a,b){
	       return arguments[0]+arguments[1];
	    }
	    var sum=add(2,3,4);
	    
	    alert(sum);  */
	    
	    
	    /*  function f1(){
	       a=2;
	    }
	    f1();
	    alert(a);  */
	    
	    /* var를 선언해주지 않으면 global 속성이 됨 전역변수처럼 */
 	    /*var a; 
	    function f1(){
	       a=1;
	       f2();
	       function f2(){
	          a=2;
	          f3();
	          function f3(){
	            a=3;
	          }
	       }
	    }
	    f1();
	    alert(a);  */
		
	    /*  0806 수업 */ 
		/* function printResult(){
			var x, y;
			x = prompt("x 값을 입력하세요",0);
			y = prompt("y 값을 입력하세요",0);
			
			x = parseInt(x);
			y = parseInt(y);
			alert(x+y);
			
		}  */
	   
	    function init(){
	    	var btn1 = document.getElementById("a");
	    	 /*btn1.onclick=printResult; */
	    	btn1.onclick=function(){
	    		var x, y;
				x = prompt("x 값을 입력하세요",0);
				y = prompt("y 값을 입력하세요",0);
				
				x = parseInt(x);
				y = parseInt(y);
				alert(x+y);
	    		
	    	}
	    }
	    window.onload=init;
	