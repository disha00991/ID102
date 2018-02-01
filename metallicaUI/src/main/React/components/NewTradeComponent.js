import React from 'react'

export default class NewTrade extends React.Component {
   
    onSubmit(e){
        e.preventDefault()
        
        var val = $("input[name='side']:checked").val()
        console.log(val)
      
        this.props.saveTradeData({
        	commodity: this.refs.commodity.value,
        	date: this.refs.date.value,  
        	side: val,
        	qty: this.refs.qty.value,
        	price: this.refs.price.value,
        	counterParty: this.refs.counterParty.value,
        	location: this.refs.location.value,
        	status:"open"
        })
    }
    
    
   

    render() {
    	
    	var location=this.props.myLocations.map((u,index)=>{
            return <option>{u.name}</option>
        })
        
        var commodity=this.props.myCommodities.map((u,index)=>{
            return <option>{u.name}</option>
        })
        
        var counterParty=this.props.myCounterparties.map((u,index)=>{
            return <option>{u.name}</option>
        })
    	

    	
    		return <div className="panel panel-default alignment new-trade-form">
    		 
    			   <div className="panel-heading">
    			   		<h3 className="panel-title">New Trade</h3>
    			   </div>
    		 
    			   <div className="panel-body">
    		
                   
       		         <fieldset>
       		             <form ref="newForm" onSubmit={this.onSubmit.bind(this)}>
       		           
       		            Trade Date:
       		            
       		         
       		                  <div className='input-group date'>
       		                      <input type='date' className="form-control" ref="date"/>
       		                      <span className="input-group-addon">
       		                          <span className="glyphicon glyphicon-calendar"></span>
       		                      </span>
       		                  </div>
       		           
       		               <br/> 
       		            
       		            
       		            <div className="form-group">
       		         Commodity:
       		         <select className="form-control" ref="commodity">
       		           {commodity}
       		         </select>
       		       </div>
       		            
       		           
       		    
       		    Side:&nbsp; &nbsp;
   		        <input type="radio" className="side" name="side" value="buy" ref="side" defaultChecked="true" />Buy &nbsp;
   		        <input type="radio" className="side" name="side" value="sell" ref="side"/>Sell  <br/> 
       		         
       		    <br/>
       		   
       		          Counterparty:<select className="form-control" ref="counterParty">
       		    
       		           {counterParty}
       		           </select>
       		        <br/>
       		           
       		          Price:<input type="number" className="form-control" ref="price" /><br/>
       		        
       		          Quantity:<input type="number" className="form-control" ref="qty"/><br/>
       		       
       		        Location:<select className="form-control" ref="location">
       		        {location}
   		           
   		           </select>
   		        <br/>
   		    
       		            <input type='submit' className="btn btn-primary" value='SAVE'/>

     		            </form>
     		            </fieldset>
     		        </div>
     		            
     		     </div>
     		          
    }
}
      
   