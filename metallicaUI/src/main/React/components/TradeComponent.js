import React from 'react';
import TradeDetails from './TradeDetailsComponent';
import {Link} from 'react-router';
export default class Trade extends React.Component{
    
	render(){
	
        
		var allTrades=this.props.myTrades.map((u,index)=>{
            return <TradeDetails {...this.props} allTrades={u} i={index}></TradeDetails>
        })
        

        return <div>
					
            
					<table className="table table-striped">
						<thead>
							<tr>
								<th>Commodity</th>
								<th>Date</th>
								<th>Side</th>
								<th>Qty (MT)</th>
								<th>Price (MT)</th>
								<th>CounterParty</th>
								<th>Location</th>
								<th>Status</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							{allTrades}
		        	  						
						</tbody>
					</table> 
				</div>
    }
}