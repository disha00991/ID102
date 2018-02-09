import React from 'react'
import ToggleDisplay from 'react-toggle-display';
import TradeComponent from './TradeComponent';

export default class SelectedTrade extends React.Component {

	componentDidMount(){
		console.log("yeah" + this.props.tradeData);
		$("#selected").trigger("reset");
		$("#new-trade-form").css("display", "none");
		$(".edit-form").prop('disabled', true);
		this.setState({tradeData: this.props.tradeData});
	}
	
    onSubmit(e){
        e.preventDefault();
        var val = $("input[name='side']:checked").val();
        this.props.editTradeData({
        	id: this.props.tradeData.id,
        	commodity: this.refs.commodity.value,
        	tradeDate: this.refs.date.value,  
        	side:val,
        	quantity: this.refs.quantity.value,
        	price: this.refs.price.value,
        	counterparty: this.refs.counterParty.value,
        	location: this.refs.location.value,
        	status:"OPEN"
        });
        this.props.fetchTradeData();
     
    }
    	
    onClickDelete(e){
    	e.preventDefault()
    	this.props.deleteTradeData(this.props.tradeData.id);
    	this.props.fetchTradeData();   
    }  

    
    onClickEdit(e){
    	e.preventDefault()
	    $(".edit-form").prop("disabled", false);
    	this.props.fetchTradeData();
    }
    
//    updateState(tradeData) {
//        this.setState({
//        	tradeData: tradeData.value
//        });
//    }

    render() {
    	
		$("#commodity").val(this.props.tradeData.commodity);
		$("#counterParty").val(this.props.tradeData.counterparty);
		$("#location").val(this.props.tradeData.location);
    	
    	var trades=this.props.myTrades;
    	var detail = <TradeComponent {...this.props} ></TradeComponent>
    	
    	var x = this.props.tradeData.tradeDate;
    	
    	var currentTime = new Date(x);
    	var month = currentTime.getMonth() + 1;
    	if(month<10)
    		month = ('0' + month).slice(-2);
    	var day = currentTime.getDate();
    	if(day<10)
    		day = ('0' + day).slice(-2);
    	var year = currentTime.getFullYear();
    	var date = year + "-" + month + "-" + day;
    	
    	var location=this.props.myLocations.map((u,index)=>{
            return <option>{u.name}</option>
        })
        
        var commodity=this.props.myCommodities.map((u,index)=>{
            return <option>{u.name}</option>
        })
        
        var counterParty=this.props.myCounterparties.map((u,index)=>{
            return <option>{u.name}</option>
        })
    	
    	return <div className="container row" id="edit-trade-form">
    		
    				<div className="col-md-8">
    					{detail}
    				</div>
    		
    				<div className="col-md-4 hiding-form">
    					<div className="panel panel-primary">
    		 
    						<div className="panel-heading panel-css">
    							<h3 className="panel-title">Trade Detail
    							
    								<button type='submit' className="btn btn-primary table-style edit" value='Submit' onClick={this.onClickEdit.bind(this)}>
    									<span className="glyphicon glyphicon glyphicon-pencil selected-glyph" aria-hidden="true"></span>
    								</button>
    		  
    							</h3>
    						</div>
    		   
    		  <div className="panel-body">
    		
       		         <fieldset className="edit-form">
       		         
       		             <form className="target" onSubmit={this.onSubmit.bind(this)} id="selected">
       		           
	       		            Trade Date:
	       		            	<div className="input-group date">
			                      <input type="date" className="form-control" defaultValue={date} ref="date"/>
			                    	  <span className="input-group-addon">
			                          	<span className="glyphicon glyphicon-calendar"></span>
			                          </span>
			                    </div>
			                    <br/>
       		                  
			                    <div className="form-group">
	       		                  Commodity:
	       		                	  <select id="commodity" className="form-control" ref="commodity" >
	       		                  		{commodity}
	       		                  	  </select>
	       		                </div>
       		            
	       		              Side:&emsp;
	       		              	<input type="radio" className="side" name="side" defaultValue="BUY" ref="side" defaultChecked={this.props.tradeData.side==="BUY"}/>Buy &emsp;
	       		              	<input type="radio" className="side" name="side" defaultValue="SELL" ref="side" defaultChecked={this.props.tradeData.side==="SELL"}/>Sell
	       		              	<br/>       		         
	       		              	<br/>
       		     
	       		              Counterparty:
	       		            	  <select className="form-control" id="counterParty" ref="counterParty">
	       		              			{counterParty}
	       		              	  </select>
	       		              	  <br/>
       		           
	       		              Price:<input type="number" className="form-control" defaultValue={this.props.tradeData.price} ref="price"/><br/>
	       		              Quantity:<input type="number" className="form-control" defaultValue={this.props.tradeData.quantity} ref="quantity"/><br/>
	       		              Location:
	       		            	  <select className="form-control" id="location" ref="location">
	       		              	  		{location}
	       		              	  </select>
	       		              	  <br/>
   		          
       		            <input type='submit' className="btn btn-css btn-size" value='UPDATE'/>

     		         </form>
     		       </fieldset>     
     		     </div>
     		   </div>
     		 </div>
     	</div> 		
    }
}
      
   