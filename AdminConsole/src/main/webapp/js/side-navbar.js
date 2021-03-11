(function($) {

	var fullHeight = function() {

		$('.js-fullheight').css('height', $(window).height());
		$(window).resize(function(){
			$('.js-fullheight').css('height', $(window).height());
		});

	};
	fullHeight();

	$('#side-menu-collapse-button').on('click', function () {
      $('#side-menu').toggleClass('active');
  });
})(jQuery);

$(document).ready(function () {

	$.ajax({
		contentType: 'application/json',
		dataType: "json",
		type: "GET",
		url: "/belinvest/admin/get-auth",
		success: function (data) {
			$admin = $('#admin');
			console.log(data.msg)
			$admin.text(data.msg)

		},
		error: function (response) {
			console.log(response.msg);
		}
	});
});
