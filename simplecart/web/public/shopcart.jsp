<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<jsp:include page="/includes/header.jsp" />
<div class="row">
	<div class="span12">
		<h2 class="page-header">
			<bean:message key="publicMessage.viewShopcart"/>
		</h2>
	</div>
</div>
<section class="section">
	<div class="container">
		<div class="row">
			<div class="col-lg-9">
				<form>
					<logic:present name="shopcart" scope="session">
					<div class="widget shop-selections">
						<table class="table table-cart">
							<thead>
								<tr>
<!-- 									<td></td> -->
									<td class="cart-product">Item</td>
									<td class="cart-quantity">Quantity</td>
									<td class="cart-total">Total</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<logic:iterate id="item" name="shopcart" property="items" indexId="itemIndex">
<!-- 										<td class="cart-remove"> -->
<!-- 										w	<a href="#"><i class="icon-remove"></i></a> -->
<!-- 										</td> -->
										<td class="cart-product">
	<!-- 										<a href="#" class="product-thumb pull-left"> -->
	<!-- 											<img src="images/samples/products/product-70-1.jpg"> -->
	<!-- 										</a> -->
											<div class="product-details">
												<h3 class="product-name">
											<%-- <bean:write name="item" property="optionId" filter="true"/> --%>
											<%-- <bean:write name="item" property="total" filter="true"/> --%>
													<a href="#"><bean:write name="item" property="name" filter="true"/></a>
												</h3>
												<div class="product-categories muted">	
<%-- 													<bean:write name="item" property="description" filter="true"/> --%>
											    </div>
											    <div class="product-categories muted">
<%-- 													<bean:write name="item" property="price" filter="true"/> --%>
												</div>
											</div>	
											<td class="cart-quantity">
												<div class="input-group">
													<bean:write name="item" property="amount" filter="true"/>
												</div>
											</td>
											<td class="cart-total">
												<span>&dollar; <bean:write name="item" property="price" filter="true"/></span>
											</td>
<%-- 											<html:link action="/ShopcartManage?activity=removeItem" indexId="itemIndex" indexed="true"><bean:message key="link.delete"/></html:link> --%>
											<br>
									</logic:iterate>


<!-- 								<tr> -->
<!-- 									<td class="cart-remove"> -->
<!-- 										<a href="#"><i class="icon-remove"></i></a> -->
<!-- 									</td> -->
<!-- 									<td class="cart-product"> -->
<!-- 										<a href="#" class="product-thumb pull-left"> -->
<!-- 											<img src="images/samples/products/product-70-1.jpg"> -->
<!-- 										</a> -->
<!-- 										<div class="product-details"> -->
<!-- 											<h3 class="product-name"> -->
<!-- 												<a href="#">Mobile &amp; Responsive Ready</a> -->
<!-- 											</h3> -->
<!-- 											<div class="product-categories muted"> -->
<!-- 												<a href="#">Sunglasses</a> -->
<!-- 											</div> -->
<!-- 											<b class="product-price"> -->
<!-- 												$35.99 -->
<!-- 											</b> -->
<!-- 										</div> -->
<!-- 									</td> -->
<!-- 									<td class="cart-quantity"> -->
<!-- 										<div class="input-group"> -->
<!-- 											<b class="input-group-btn"> -->
<!-- 												<button class="btn btn-small" type="button"><i class="icon-plus"></i></button> -->
<!-- 											</b> -->
<!-- 											<input class="form-control input-small text-center" type="text" value="1"> -->
<!-- 											<b class="input-group-btn"> -->
<!-- 												<button class="btn btn-small" type="button"><i class="icon-minus"></i></button> -->
<!-- 											</b> -->
<!-- 										</div> -->
<!-- 									</td> -->
<!-- 									<td class="cart-total"> -->
<!-- 										<span>&dollar; 35.99</span> -->
<!-- 									</td> -->
<!-- 								</tr> -->
<!-- 								<tr> -->
<!-- 									<td class="cart-remove"> -->
<!-- 										<a href="#"><i class="icon-remove"></i></a> -->
<!-- 									</td> -->
<!-- 									<td class="cart-product"> -->
<!-- 										<a href="#" class="product-thumb pull-left"> -->
<!-- 											<img src="images/samples/products/product-70-1.jpg"> -->
<!-- 										</a> -->
<!-- 										<div class="product-details"> -->
<!-- 											<h3 class="product-name"> -->
<!-- 												<a href="#">Mobile &amp; Responsive Ready</a> -->
<!-- 											</h3> -->
<!-- 											<div class="product-categories muted"> -->
<!-- 												<a href="#">Sunglasses</a> -->
<!-- 											</div> -->
<!-- 											<b class="product-price"> -->
<!-- 												$35.99 -->
<!-- 											</b> -->
<!-- 										</div> -->
<!-- 									</td> -->
<!-- 									<td class="cart-quantity"> -->
<!-- 										<div class="input-group"> -->
<!-- 											<b class="input-group-btn"> -->
<!-- 												<button class="btn btn-small" type="button"><i class="icon-plus"></i></button> -->
<!-- 											</b> -->
<!-- 											<input class="form-control input-small text-center" type="text" value="1"> -->
<!-- 											<b class="input-group-btn"> -->
<!-- 												<button class="btn btn-small" type="button"><i class="icon-minus"></i></button> -->
<!-- 											</b> -->
<!-- 										</div> -->
<!-- 									</td> -->
<!-- 									<td class="cart-total"> -->
<!-- 										<span>&dollar; 35.99</span> -->
<!-- 									</td> -->
<!-- 								</tr> -->
																
							</tbody>
						</table>
					</div>
					</logic:present>
				</form>
				<logic:notPresent scope="session" name="shopcart"> 
</logic:notPresent>
			</div>					
			<div class="col-lg-3">
<!-- 				<form class="widget"> -->
<!-- 					<h3>Coupon Code</h3> -->
<!-- 					<div class="input-group"> -->
<!-- 						<input type="text" class="form-control" placeholder="Place promotion code here.."> -->
<!-- 						<b class="input-group-btn"> -->
<!-- 							<button type="submit" class="btn btn-default"> -->
<!-- 								Apply -->
<!-- 							</button> -->
<!-- 						</b> -->
<!-- 					</div> -->
<!-- 				</form> -->
				<html:form action="/ManageCustomer" styleClass="widget" >
					<h3>For new customers</h3>
					<table class="table table-summary">
						<tbody>
							<tr class="cart-subtotal">
								<th>Cart Subtotal</th>
								<td><span class="amount">&pound;945</span></td>
							</tr>
							<tr class="shipping">
								<th>Shipping</th>
								<td>Free Shipping<input type="hidden" name="shipping_method" id="shipping_method" value="free_shipping"></td>
							</tr>
							<tr class="total">
								<th>Order Total</th>
								<td>
									<span class="amount">&pound;945</span>
								</td>
							</tr>
						</tbody>
					</table>
<!-- 					<button class="btn btn-default btn-block"> -->
<!-- 						Update totals -->
<!-- 					</button> -->
<!-- 						<button type="submit" class="btn btn-primary"> -->
<!-- 						  <i class="icon-user icon-white"></i> Sign in -->
<!-- 						</button> -->
	        <logic:empty name="loggedInUser" scope="session"> 
						<html:link forward="beginCheckout" styleClass="btn btn-large btn-success btn-block"><bean:message key="publicLink.checkout"/></html:link>
	        </logic:empty>
	        <logic:notEmpty name="loggedInUser" scope="session">
	        <html:hidden property="activity" value="login"/>
	        						<button type="submit" class="btn btn-large btn-success btn-block">
						  <i class="icon-user icon-white"></i> <bean:message key="publicLink.checkout"/>
						</button>
<%-- 						<html:link forward="beginCheckout" styleClass="btn btn-large btn-success btn-block"><bean:message key="publicLink.checkout"/></html:link> --%>
<%-- 						<html:link forward="beginCheckout" styleClass="btn btn-large btn-success btn-block"><bean:message key="publicLink.checkout"/></html:link> --%>
	        </logic:notEmpty>
<!-- 					<button class="btn btn-large btn-success btn-block"> -->
<!-- 					</button> -->
				</html:form>
			</div>
		</div><!--end:.row-->
	</div><!--end:.container-->
</section><!--end:.section-->					
<%-- <logic:present name="shopcart" scope="session"> --%>
<%-- <logic:iterate id="item" name="shopcart" property="items" indexId="itemIndex"> --%>
<%-- <bean:write name="item" property="optionId" filter="true"/>  --%>
<%-- <bean:write name="item" property="name" filter="true"/> --%>
<%-- <bean:write name="item" property="description" filter="true"/> --%>
<%-- <bean:write name="item" property="amount" filter="true"/> --%>
<%-- <bean:write name="item" property="price" filter="true"/> --%>
<%-- <bean:write name="item" property="total" filter="true"/> --%>
<%-- <html:link action="/ShopcartManage?activity=removeItem" indexId="itemIndex" indexed="true"><bean:message key="link.delete"/></html:link> --%>
	<!-- <br> -->
	<%-- </logic:iterate> --%>
	<%-- </logic:present> --%>

<br><br>

<jsp:include page="/includes/footer.jsp" />
