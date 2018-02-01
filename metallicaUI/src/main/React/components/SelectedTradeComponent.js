import React from 'react'
import ToggleDisplay from 'react-toggle-display';
import TradeComponent from './TradeComponent';

export default class SelectedTrade extends React.Component {

	componentDidMount(){
		 $(".new-trade-form").hide();
	}
	
    onSubmit(e){
    	
        e.preventDefault()
        
        var val = $("input[name='side']:checked").val()
        console.log(val)
        
        this.props.editTradeData({date: this.refs.date.value, 
        	commodity: this.refs.commodity.value, 
        	side:val,
        	price: this.refs.price.value,
        	qty: this.refs.qty.value,
        	location: this.refs.location.value
        })
    }
    
    onClickEdit(e){
    	e.preventDefault()
	    $(".edit-form").attr("disabled", false);
    }

    render() {
    	
    	var trades=this.props.myTrades;
    	console.log(trades)
    	var detail = <TradeComponent {...this.props} ></TradeComponent>
    	
    	
    	var x = this.props.tradeData.date;
    	console.log(x);
    	
    	var currentTime = new Date(x)
    	var month = currentTime.getMonth() + 1
    	if(month<10)
    		month = ('0' + month).slice(-2)
    	var day = currentTime.getDate()
    	if(day<10)
    		day = ('0' + day).slice(-2)
    	var year = currentTime.getFullYear()
    	var date = year + "-" + month + "-" + day
    	console.log(date);
    	
       
    		return <div className="container row">
    		
    				<div className="col-md-8">
    					{detail}
    					</div>
    		
    					<div className="col-md-4">
    		<div className="panel panel-default">
    		 
    		<div className="panel-heading">
    		    <h3 className="panel-title">Trade Detail
    		    <button type='submit' className="btn btn-primary table-style edit" value='Submit' onClick={this.onClickEdit.bind(this)}>
    	    	<span className="glyphicon glyphicon glyphicon-pencil" aria-hidden="true"></span>
    	    	</button>
    		    <button type='submit' className="btn btn-primary table-style delete" value='Submit'>
    	    	<span className="glyphicon glyphicon glyphicon-trash" aria-hidden="true"></span>
    	    	</button>
    	    	</h3>
    		  </div>
    		   
    		  <div className="panel-body">
    		
       		         <fieldset className="edit-form" disabled>
       		         
       		             <form onSubmit={this.onSubmit.bind(this)}>
       		           
	       		            Trade Date:
	       		            
	       		            	<div className="input-group date">
			                      <input type="date" className="form-control" value={date} ref="date"/>
			                      <span className="input-group-addon">
			                          <span className="glyphicon glyphicon-calendar"></span>
			                      </span>
			                  </div>
			                  <br/>
       		                  
       		                 		               
       		            
       		            
		       		        <div className="form-group">
		       		         Commodity:
		       		         <select className="form-control" value={this.props.tradeData.commodity} ref="commodity">
		       		           <option>Aluminium</option>
		       		           <option>Copper</option>
		       		           <option>Zinc</option>
		       		           <option>Gold</option>
		       		           <option>Silver</option>
		       		         </select>
		       		       </div>
       		            
       		           
		       		        Side:&nbsp; &nbsp;
		       		        <input type="radio" name="side" value="buy" ref="side" checked={this.props.tradeData.side==="buy"}/>Buy &nbsp;
		       		         <input type="radio" name="side" value="sell" ref="side" checked={this.props.tradeData.side==="sell"}/>Sell  <br/>       		         
		       		    <br/>
       		     
       		 
  		       
  	
          		       
       		       
       		          Counterparty:<select className="form-control" value={this.props.tradeData.counterParty} ref="counterParty">
       		           <option>Lorem</option>
       		           <option>Ipsum</option>
       		           <option>Dolor</option>
       		           <option>Amet</option>
       		           </select>
       		           <br/>
       		           
       		        
       		        
       		         Price:<input type="number" className="form-control price" value={this.props.tradeData.price} ref="price"/><br/>
       		        
       		        
       		        
       		        Quantity:<input type="number" className="form-control" value={this.props.tradeData.qty} ref="qty"/><br/>
       		        
       		        
       		        
       		       Location:<select className="form-control" value={this.props.tradeData.location} ref="location">
   		           <option>New York</option>
   		           <option>London</option>
   		           <option>Singapore</option>
   		           <option>Denver</option>
   		           </select>
   		           <br/>
   		           
   		           
       		            <input type='submit' className="btn btn-primary" value='UPDATE'/>

     		            </form>
     		            </fieldset>
     		            
     		        </div>
     		            
     		        </div>
     		     </div>
     		 </div> 
     		
    }
}
      
   