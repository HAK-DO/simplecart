<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/link-tags.tld" prefix="links"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<jsp:include page="/includes/header.jsp" />
<div class="row">
	<div class="span12">
		<h2 class="page-header">
			<bean:message key="publicMessage.viewProductDetail" />
		</h2>
	</div>
</div>
<div class="row">
	<div class="col-md-6">
		<img src="http://farm1.staticflickr.com/1/132375_0ca82ae31e.jpg" alt="">
	</div>
	<div class="col-md-6 text-left"> 
		<div class="features">
			<dl class="dl-horizontal">
			  <dt class="">Name :</dt>
			  <dd><bean:write name="product" property="name" filter="true" /></dd>
			  <dt>Author :</dt>
			  <dd><bean:write name="product" property="searchDetails.searchMetaAuthor" filter="true" /></dd>
			  <dt>Keywords :</dt>
			  <dd><bean:write name="product" property="searchDetails.searchMetaKeywords" filter="true" /></dd>
			  <dt>Keywords :</dt>
			  <dd>$549.99</dd>
			</dl>
		</div>
		<div class="edit-buttons">
			<a class="remove">Remove</a>
			<html:form action="/ShopcartManage" focus="optionId">
				<html:select property="optionId" name="shopcartForm">
				   <option value="2">2</option>
					<html:options collection="options" property="id" labelProperty="name" />
					<%--     <html:options collection="options" property="id" labelProperty="name"/> --%>
					<%--      <html:options collection="options" property="id" labelProperty="name"/> --%>
					<%--         <logic:iterate id="option" name="options"> --%>
					<%--         <option value='<bean:write name="option" property="id" filter="true"/>'><bean:write name="option" property="name" filter="true"/> --%>
					<%--         </logic:iterate> --%>
				</html:select>
				<html:text property="amount" size="15" />
				<html:hidden property="activity" value="addItem" /> <br><br> 
				<p><button type="button" class="btn btn-success">Order</button>
<!-- 				<button type="button" class="btn btn-info">Add Cart</button>  -->
				<html:submit property="Submit" value="Add Cart" styleClass="btn btn-info"/>
				</p>
			</html:form>
		</div>
	</div>   
</div>
<!-- <br/> -->
<!--   <div class="bs-docs-section"> -->
<!--     <div class="bs-example bs-example-tabs"> -->
<!--       <ul id="myTab" class="nav nav-tabs"> -->
<!--         <li class="active"><a href="#home" data-toggle="tab">Home</a></li> -->
<!--         <li><a href="#profile" data-toggle="tab">Profile</a></li> -->
<!--       </ul> -->
<!--       <div id="myTabContent" class="tab-content"> -->
<!--         <div class="tab-pane fade in active" id="home"> -->
<%--         	<p><bean:write name="product" property="description" filter="true" /></p>  --%>
<!--         </div> -->
<!--         <div class="tab-pane fade" id="profile"> -->
<!--           <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.</p> -->
<!--         </div> -->
<!--         <div class="tab-pane fade" id="dropdown1"> -->
<!--           <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh mi whatever gluten-free, carles pitchfork biodiesel fixie etsy retro mlkshk vice blog. Scenester cred you probably haven't heard of them, vinyl craft beer blog stumptown. Pitchfork sustainable tofu synth chambray yr.</p> -->
<!--         </div> -->
<!--         <div class="tab-pane fade" id="dropdown2"> -->
<!--           <p>Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party before they sold out master cleanse gluten-free squid scenester freegan cosby sweater. Fanny pack portland seitan DIY, art party locavore wolf cliche high life echo park Austin. Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out farm-to-table VHS viral locavore cosby sweater. Lomo wolf viral, mustache readymade thundercats keffiyeh craft beer marfa ethical. Wolf salvia freegan, sartorial keffiyeh echo park vegan.</p> -->
<!--         </div> -->
<!--       </div> -->
<!--     </div>/example -->
<!-- </div> -->


<!-- <section class="section"> -->
<!-- 	<div class="container"> -->
<!-- 		<div class="row"> -->
<!-- 			<div class="col-lg-5"> -->
<!-- 				<div class="product-demo tabs"> -->
<!-- 					<div class="tab-content"> -->
<!-- 						<div class="tab-pane fade active in" id="tab-1"> -->
<!-- 							<img src="images/samples/products/product-detail-1.jpg" /> -->
<!-- 						</div> -->
<!-- 						<div class="tab-pane fade" id="tab-2"> -->
<!-- 							<img src="images/samples/products/product-detail-2.jpg" /> -->
<!-- 						</div> -->
<!-- 						<div class="tab-pane fade" id="tab-3"> -->
<!-- 							<img src="images/samples/products/product-detail-3.jpg" /> -->
<!-- 						</div> -->
<!-- 						<div class="tab-pane fade" id="tab-4"> -->
<!-- 							<img src="images/samples/products/product-detail-4.jpg" /> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- <!-- 					<ul class="nav nav-tabs"> --> 
<!-- <!-- 						<li class="span3 active"> --> 
<!-- <!-- 							<a href="#tab-1" data-toggle="tab"> --> 
<!-- <!-- 								<img src="images/samples/products/product-detail-1.jpg" /> --> 
<!-- <!-- 								<b></b> --> 
<!-- <!-- 							</a> --> 
<!-- <!-- 						</li> --> 
<!-- <!-- 						<li class="span3"> --> 
<!-- <!-- 							<a href="#tab-2" data-toggle="tab"> --> 
<!-- <!-- 								<img src="images/samples/products/product-detail-2.jpg" /> --> 
<!-- <!-- 								<b></b> --> 
<!-- <!-- 							</a> --> 
<!-- <!-- 						</li> --> 
<!-- <!-- 						<li class="span3"> --> 
<!-- <!-- 							<a href="#tab-3" data-toggle="tab"> --> 
<!-- <!-- 								<img src="images/samples/products/product-detail-3.jpg" /> --> 
<!-- <!-- 								<b></b> --> 
<!-- <!-- 							</a> --> 
<!-- <!-- 						</li>  -->
<!-- <!-- 						<li class="span3">  -->
<!-- <!-- 							<a href="#tab-4" data-toggle="tab">  -->
<!-- <!-- 								<img src="images/samples/products/product-detail-4.jpg" />  -->
<!-- <!-- 								<b></b> --> 
<!-- <!-- 							</a> --> 
<!-- <!-- 						</li> --> 
<!-- <!-- 					</ul> --> 
<!-- 				</div>end:.product-demo -->
<!-- 				<div class="visible-phone"> -->
<!-- 					<br> -->
<!-- 					<hr> -->
<!-- 					<br> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="col-lg-7"> -->
<!-- 				<div class="product-header"> -->
<!-- 					<h3>&pound;35.99</h3> -->

<!-- 					<div class="cart-quantity"> -->
<!-- 						<div class="input-group"> -->
<!-- <!-- 							<b class="input-group-btn"><button class="btn" type="button"><i class="icon-plus"></i></button></b> --> 
<!-- 							<input class="form-control text-center" id="appendedInputButtons" type="text" value="1"> -->
<!-- <!-- 							<b class="input-group-btn"><button class="btn" type="button"><i class="icon-minus"></i></button></b> --> 
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					&nbsp; -->
<!-- 					&nbsp; -->
<!-- 					<br/> -->
<!-- 					<button class="btn btn-success"> -->
<!-- 						Add to cart -->
<!-- 					</button> -->

<!-- 					<div class="btn-group pull-right"> -->
<!-- <!-- 						<button class="btn"> --> 
<!-- <!-- 							<i class="icon-star"></i> --> 
<!-- <!-- 						</button> --> 
<!-- <!-- 						<button class="btn"> --> 
<!-- <!-- 							<i class="icon-heart"></i> --> 
<!-- <!-- 						</button>  -->
<!-- 					</div> -->
<!-- 				</div>end:.product-header -->

<!-- 				<hr> -->

<!-- 				<div class="product-summary"> -->
<!-- 					<p>Meggings next level yr, 90′s small batch four loko brunch wes anderson quinoa fixie american apparel flexitarian pitchfork neutra.  -->
<!-- 					Authentic sartorial wes anderson scenester. -->
<!-- 					Regular fit. Brooklyn high life plaid cardigan. Fixie american apparel flexitarian pitchfork neutra. -->
<!-- 					Locavore typewriter blue bottle. Constructed in washed cotton jersey.</p> -->
					
<!-- 					<ul class="hidden"> -->
<!-- 						<li>Constructed in washed cotton jersey</li> -->
<!-- 						<li>Locavore typewriter blue bottle</li> -->
<!-- 						<li>Fixie american apparel flexitarian pitchfork neutra</li> -->
<!-- 						<li>Brooklyn high life plaid cardigan</li> -->
<!-- 						<li>Regular fit</li> -->
<!-- 						<li>Authentic sartorial wes anderson scenester</li> -->
<!-- 					</ul> -->
<!-- 				</div>end:.product-summary -->

<!-- 				<br> -->

<!-- 				<div class="product-accordion accordion"> -->
<!-- 					<div class="accordion-group"> -->
<!-- 						<div class="accordion-heading"> -->
<!-- 							<a class="accordion-toggle" data-toggle="collapse" data-parent=".accordion" href="#collapseTwo"> -->
<!-- 							Additional Information -->
<!-- 							</a> -->
<!-- 						</div> -->
<!-- 						<div id="collapseTwo" class="accordion-body in collapse"> -->
<!-- 							<div class="accordion-inner"> -->
<!-- 								<table class="product-attribute table"> -->
<!-- 									<tbody> -->
<!-- 										<tr class=""> -->
<!-- 											<th>Weight</th> -->
<!-- 											<td>1.3 kg</td> -->
<!-- 										</tr> -->
<!-- 										<tr class="alt"> -->
<!-- 											<th>Dimensions</th> -->
<!-- 											<td>90 x 60 x 90 cm</td> -->
<!-- 										</tr> -->
<!-- 										<tr class=""> -->
<!-- 											<th>Composition</th> -->
<!-- 											<td>100% Cotton</td> -->
<!-- 										</tr> -->

							
<!-- 										<tr class="alt"> -->
<!-- 											<th>Size</th> -->
<!-- 											<td>This style comes in a regular fit which fits true to size.</td> -->
<!-- 										</tr> -->
<!-- 										<tr class=""> -->
<!-- 											<th>Other Info</th> -->
<!-- 											<td>Machine wash according to instructions on care label</td> -->
<!-- 										</tr> -->
<!-- 									</tbody> -->
<!-- 								</table> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="accordion-group"> -->
<!-- 						<div class="accordion-heading"> -->
<!-- 							<a class="accordion-toggle" data-toggle="collapse" data-parent=".accordion" href="#collapseThree"> -->
<!-- 							Reviews (3) -->
<!-- 							</a> -->
<!-- 						</div> -->
<!-- 						<div id="collapseThree" class="accordion-body in collapse"> -->
<!-- 							<div class="accordion-inner"> -->
<!-- 								<ul class="product-reviews unstyled"> -->
<!-- 									<li> -->
<!-- 										<a href="#" class="thumb pull-left"> -->
<!-- <!-- 											<img src="images/samples/avatar/avatar-1.jpg" width="50" /> --> 
<!-- 										</a> -->
<!-- 										<div class="review"> -->
<!-- 											<a href="review-author">Andy Parr</a> -->
<!-- 											&nbsp; -->
<!-- 											<span class="muted small">19 July 2013</span> -->
<!-- 											<div class="review-content"> -->
<!-- 												This is an awesome pants with authentic sartorial wes anderson scenester. Regular fit. Brooklyn high life plaid cardigan. Fixie american apparel flexitarian pitchfork neutra.  -->
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 									</li> -->
<!-- 									<li> -->
<!-- 										<a href="#" class="thumb pull-left"> -->
<!-- <!-- 											<img src="images/samples/avatar/avatar-2.jpg" width="50" /> --> 
<!-- 										</a> -->
<!-- 										<div class="review"> -->
<!-- 											<a href="review-author">Brian Lamb</a> -->
<!-- 											&nbsp; -->
<!-- 											<span class="muted small">21 July 2013</span> -->
<!-- 											<div class="review-content"> -->
<!-- 												Meggings next level yr, 90′s small batch four loko brunch wes anderson quinoa fixie american apparel  -->
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 									</li> -->
<!-- 									<li> -->
<!-- 										<a href="#" class="thumb pull-left"> -->
<!-- <!-- 											<img src="images/samples/avatar/avatar-3.jpg" width="50" /> --> 
<!-- 										</a> -->
<!-- 										<div class="review"> -->
<!-- 											<b href="review-author">You</b> -->
<!-- 											&nbsp; -->
<!-- 											<span class="muted small">Your comment is waiting for moderation</span> -->
<!-- 											<div class="review-content"> -->
<!-- 												Thanks for the review, I will buy this too! -->
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 									</li> -->
<!-- 									<li> -->
<!-- 										<form> -->
<!-- 											<textarea class="form-control" placeholder="Add your review here..." rows="4" class="input-block-level"></textarea> -->
<!-- 											<br> -->
<!-- 											<button class="btn btn-primary">Submit Your Review</button> -->
<!-- 										</form> -->
<!-- 									</li> -->
<!-- 								</ul> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div>end:.product-accordian -->
<!-- 				<hr> -->
<!-- 				Need help? Call customer services on 0800 123 4567. -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div>end:.container -->
<!-- </section>end:.section -->

<jsp:include page="/includes/footer.jsp" />
