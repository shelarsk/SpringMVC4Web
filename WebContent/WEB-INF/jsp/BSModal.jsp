<!-- /.container -->
<div class="container">
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog  modal-lg" >
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel"></h4>
					</div>
					<div class="modal-body">
					<!-- 16:9 aspect ratio -->
						<div class="embed-responsive embed-responsive-16by9">
						  <iframe class="embed-responsive-item" ></iframe>
						</div>
<!-- 						<iframe frameborder="0"></iframe> -->
					</div>
					<div class="modal-footer"></div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		
		<div class="modal fade" id="showPopUp" tabindex="-1" role="dialog"
			aria-labelledby="showPopUpLabel" aria-hidden="true">
			<div class="modal-dialog  modal-lg" >
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="showPopUpLabel"></h4>
					</div>
					<div class="modal-body">
					<!-- 16:9 aspect ratio -->
						<div class="embed-responsive embed-responsive-16by9">
						  <iframe class="embed-responsive-item" ></iframe>
						</div>
<!-- 						<iframe frameborder="0"></iframe> -->
					</div>
					<div class="modal-footer"></div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		
		<div class="modal fade" id="showPopUpReload" tabindex="-1" role="dialog"
			aria-labelledby="showPopUpReloadLabel" aria-hidden="true">
			<div class="modal-dialog  modal-lg" >
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="showPopUpReloadLabel"></h4>
					</div>
					<div class="modal-body">
					<!-- 16:9 aspect ratio -->
						<div class="embed-responsive embed-responsive-16by9">
						  <iframe class="embed-responsive-item" ></iframe>
						</div>
<!-- 						<iframe frameborder="0"></iframe> -->
					</div>
					<div class="modal-footer"></div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		
	</div>
	
	<script>
		$('a.modalButton').on('click', function(e) {
			var src = $(this).attr('data-src');
			var height = $(this).attr('data-height') || 300;
			var width = $(this).attr('data-width') || 400;
			var dLable = $(this).attr('data-lable') || 111;
			var dAct = $(this).attr('data-Act') || 'myModal';
			
			//alert("dAct =>"+dAct);
			
			if('myModal'==dAct)
			{
				//alert('in my modal');
				$("#myModal iframe").attr({
					'src' : src
				});
				$('#myModalLabel').text(dLable);
			}
			
			if('showPopUp'==dAct)
			{
				//alert('in showPopUp');
				$("#showPopUp iframe").attr({
					'src' : src
				});
				$('#showPopUpLabel').text(dLable);
			}
			
			if('showPopUpReload'==dAct)
			{
				//alert('in showPopUpReload');
				$("#showPopUpReload iframe").attr({
					'src' : src
				});
				$('#showPopUpReloadLabel').text(dLable);
			}
			
			
		});
		
		$('#myModal').on('hidden.bs.modal', function () {
			  // do something…
			//  alert("on close button .... ");
			  $("#myModal iframe").attr({
					'src' : ""
				});
			  $('#myModalLabel').text("");
			 // alert("iframe lable done ....")
			});
		
		$('#showPopUp').on('hidden.bs.modal', function () {
			  // do something…
			 // alert("on close showPopUp .... ");
			  $("#showPopUp iframe").attr({
					'src' : ""
				});
			  $('#showPopUpLabel').text("");
			 // alert("iframe lable done ....")
			});
		
		$('#showPopUpReload').on('hidden.bs.modal', function () {
			  // do something…
			//  alert("on close button showPopUpReload .... ");
			  $("#showPopUpReload iframe").attr({
					'src' : ""
				});
			  $('#showPopUpReloadLabel').text("");
			 // alert("iframe lable done ....")
			  location.reload(true);
			});
	</script>