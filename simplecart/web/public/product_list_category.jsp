<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/link-tags.tld" prefix="links"%>

<jsp:include page="/includes/header.jsp" />
<h2>
	<bean:message key="publicMessage.viewProductListing" />
	<hr/>
</h2>
    <div class="bs-example">
<div class="row">
<!--         <div class="col-sm-6 col-md-4"> -->
<!--           <div class="thumbnail"> -->
<!--             <img data-src="holder.js/300x200" alt="Generic placeholder thumbnail"> -->
<!--             <div class="caption"> -->
<!--               <h3>Thumbnail label</h3> -->
<!--               <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p> -->
<!--               <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p> -->
<!--             </div> -->
<!--           </div> -->
<!--         </div> -->
<logic:iterate id="product" name="products">
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img data-src="holder.js/300x200" alt="...">
      <div class="caption">
        <h3><bean:write name="product" property="name" filter="true" /></h3>
		<p><bean:write name="product" property="description"  filter="true" /></p>        
        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
		<links:manageProduct page="/CatalogBrowse" activity="detail">
			<bean:write name="product" property="name" filter="true" />
		</links:manageProduct>
      </div>
    </div>
  </div>
</logic:iterate>
</div>		
<jsp:include page="/includes/footer.jsp" />
