import React from 'react'

export default class NewTrade extends React.Component {
   
	onSubmit(e){
        e.preventDefault();
        
        var val = $("input[name='side']:checked").val();
        this.props.saveTradeData({
        	commodity: this.refs.commodity.value,
        	tradeDate: this.refs.date.value,  
        	side: val,
        	quantity: this.refs.qty.value,
        	price: this.refs.price.value,
        	counterparty: this.refs.counterParty.value,
        	location: this.refs.location.value,
        	status:"OPEN",
        	trader:1
        });
        this.props.fetchTradeData();
    }
    
    onClickSave(e) {
   	 	e.preventDefault()
   }
    
    validatePrice() {        
        let priceField = $('#price')
        var x = priceField.val();
        if (x <= 0) {
        	priceField.closest('div').addClass('has-error');
        	
            let errorBlock = `
                <div class="help-block">
                    Price should be greater than zero
                </div>
            `;
            
            priceField.next('div').remove()
            priceField.after(errorBlock)
            priceField.focus()
            priceField.val("")
    } else {
    	priceField.closest('div').removeClass('has-error');
    	priceField.next('div').remove();
    }
        
    }
    validateQuantity() {    	
        let qtyField = $('#qty')
        var x = qtyField.val();
        if (x <= 0) {
        	qtyField.closest('div').addClass('has-error');
        	
            let errorBlock = `
                <div class="help-block">
                    Quantity should be greater than zero
                </div>
            `;
            
            qtyField.next('div').remove();
            qtyField.after(errorBlock);
            qtyField.focus();
            qtyField.val("")
    } else {
    	qtyField.closest('div').removeClass('has-error');
    	qtyField.next('div').remove();
    }
    }
   
    render() {
    	    	
    	var location=this.props.myLocations.map((u,index)=>{
            return <option key={index*Math.random()}>{u.name}</option>
        })
        
        var commodity=this.props.myCommodities.map((u,index)=>{
            return <option key={index*Math.random()}>{u.name}</option>
        })
        
        var counterParty=this.props.myCounterparties.map((u,index)=>{
            return <option key={index*Math.random()}>{u.name}</option>
        })
    	
        
    	return <div className="panel panel-primary alignment div-background" id="new-trade-form">
		 
		   			<div className="panel-heading">
		   					<h3 className="panel-title">New Trade</h3>
		   			</div>
	 
		   			<div className="panel-body">
	
        
		   			<fieldset>
		   				<form name="myForm" ref="newForm" data-toggle="validator" onSubmit={this.onSubmit.bind(this)}>
	           
		   					Trade Date:
		   						<div className='input-group date'>
		   							<input type='date' className="form-control" ref="date" required/>
		   								<span className="input-group-addon">
		   									<span className="glyphicon glyphicon-calendar"></span>
		   								</span>
		   						</div>
		   						<br/> 
	            
	            
		   					<div className="form-group">
		   					Commodity:
		   							<select className="form-control" ref="commodity" id="commodity" required>
		   								<option disabled selected> -- select a commodity -- </option>
		   								{commodity}
		   							</select>
		   							</div>
	            
		   					Side:&nbsp; &nbsp;
		   						<input type="radio" className="side" name="side" value="BUY" ref="side" defaultChecked="true" />Buy &nbsp;
		   						<input type="radio" className="side" name="side" value="SELL" ref="side"/>Sell  
		   					<br/>       
		   					<br/>
	 
		   					<div className="form-group">
		   					Counterparty:
		   							<select className="form-control" ref="counterParty" required>
		   								<option disabled selected defaultValue=""> -- select a counter party -- </option>
		   								{counterParty}
		   							</select>
		   					</div>
		   					<br/>
	     
		   					<div className="form-group">
		   						Price($):<input id="price" name="price" type="number" step="any" onInput={this.validatePrice.bind(this)} className="form-control" ref="price" required/>	
		   					</div>
		   					<br/>
	        
		   					<div className="form-group">
		   						Quantity(MT):<input id="qty" name="qty" type="number" step="any" onInput={this.validateQuantity.bind(this)} className="form-control" ref="qty" required/>
		   					</div>
		   					<br/>
	          
		   					<div className="form-group">
		   						Location:
		   								<select className="form-control" ref="location" required>
		   									<option disabled selected value=""> -- select a location -- </option>
		   									{location}
		   								</select>   								
		   					</div>
		   					<br/>
        
		   					<input type='submit' className="btn btn-css btn-size" value='SAVE'/>
		   				</form>
	            </fieldset>
	        </div>     
	     </div>
    	}
}
      
   