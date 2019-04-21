	$("#examinationImages").change(function() {
		updateExaminationImages(this,'div.gallery');
	});
function updateExaminationImages(input,placeToInsertImagePreview) {

	  if (input.files && input.files[0]) {
		var filesAmount = input.files.length;

	       for (i = 0; i < filesAmount; i++) {  
			var reader = new FileReader();
	
			reader.onload = function(event) {
				$($.parseHTML('<img>')).attr('src', event.target.result).appendTo(placeToInsertImagePreview);
			}
	
			reader.readAsDataURL(input.files[0]);
		  }
	  } 
	};



	$("#endDate").change(function() {
		let startDateVal = $("#startDate").val();
		let endDateErrors = $("#endDateErrors");
		let startDateErrors =$("#startDateErrors");
		
		if("" ==startDateVal){
			endDateElement.val('');
			startDateErrors.append("Please fill start date before end date")
		}else{
			let startDateElement = new Date(startDateVal);	
			let endDateElement =$("#endDate");
			let endDate = new Date(endDateElement.val());
			let isValid = dateCompare(startDateElement, endDateElement);
				if (!isValid){
					endDateElement.val('');
					endDateErrors.append('end date must be after start date');
				}
		}		
	});
		function dateCompare(date1, date2){
			return date2 > date1;
		};
