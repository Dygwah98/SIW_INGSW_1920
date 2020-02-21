/* JS Document */

/******************************

[Table of Contents]

1. Vars and Inits
2. Set Header
3. Init Menu
4. Init Date Picker


******************************/

function invia(event){
    $.ajax({
       type: "POST",
       url: "addemail",
     
       data: {
          email : $("#email").val()
       },
       success:function(){
    	   alert("Registrazione effettuata!!");
    	   window.location.replace("blog.jsp");
    	  
       },
        error : function () {
            alert("Registrazione fallita!!");
        }
    });
}

function sing(event){
    $.ajax({
       type: "GET",
       url: "singolopost",
     
       data: {
          identificativo : $("#identificativo").val()
       },
       success:function(){
    	   window.location.replace("singoloPost.jsp");
    	  
       },
        error : function () {
            alert("errore nel singolo post");
     	   window.location.replace("blog.jsp");

        }
    });
}

$(document).ready(function()
{
	"use strict";

	/* 

	1. Vars and Inits

	*/

	var header = $('.header');

	setHeader();

	$(window).on('resize', function()
	{
		setHeader();

		setTimeout(function()
		{
			$(window).trigger('resize.px.parallax');
		}, 375);
	});

	$(document).on('scroll', function()
	{
		setHeader();
	});

	initMenu();
	initDatePicker();

	/* 

	2. Set Header

	*/

	function setHeader()
	{
		if($(window).scrollTop() > 91)
		{
			header.addClass('scrolled');
		}
		else
		{
			header.removeClass('scrolled');
		}
	}

	/* 

	3. Init Menu

	*/

	function initMenu()
	{
		if($('.menu').length)
		{
			var menu = $('.menu');
			var hamburger = $('.hamburger');
			var close = $('.menu_close');

			hamburger.on('click', function()
			{
				menu.toggleClass('active');
			});

			close.on('click', function()
			{
				menu.toggleClass('active');
			});
		}
	}

	/* 

	4. Init Date Picker

	*/

	function initDatePicker()
	{
		if($('.datepicker').length)
		{
			var datePickers = $('.datepicker');
			datePickers.each(function()
			{
				var dp = $(this);
				// Uncomment to use date as a placeholder
				// var date = new Date();
				// var dateM = date.getMonth() + 1;
				// var dateD = date.getDate();
				// var dateY = date.getFullYear();
				// var dateFinal = dateM + '/' + dateD + '/' + dateY;
				var placeholder = dp.data('placeholder');
				dp.val(placeholder);
				dp.datepicker();
			});
		}	
	}

});