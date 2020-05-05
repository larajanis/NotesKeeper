$(document).ready(function() {
	$('.modal').modal();
	$('.collapsible').collapsible();

	$("#student").click(function() {
		$('#login_modal').modal('open');
	});

	$("#faculty").click(function() {
		$('#login_modal').modal('open');
	});

	$("#login_submit").click(function() {
		$("#login").submit();
	});
	
	$("#fileupload").click(function() {
		$("#fileUploader").submit();
	});
	
	$("#submit_request").click(function() {
		$("#requestForm").submit();
	});

});