import React from 'react';
import {Link} from 'react-router';

export default class TradeDetails extends React.Component{
	
	onSubmit(e){
        e.preventDefault()
        this.props.deleteTradeData(this.props.allTrades.id);
        this.props.fetchTradeData();
    } 
	
    render(){
    	var x = this.props.allTrades.date;
    	
    	var currentTime = new Date(x);
    	var month = currentTime.getMonth() + 1
    	if(month<10)
    		month = ('0' + month).slice(-2);
    	var day = currentTime.getDate();
    	if(day<10)
    		day = ('0' + day).slice(-2)
    	var year = currentTime.getFullYear();
    	var date = year + "-" + month + "-" + day;
    
    	return <tr>
        			<td id="form">
        				<Link to={`/edit/${this.props.allTrades.id}`}>
        					{this.props.allTrades.commodity}    
        				</Link>
        			</td>
        			<td>{this.props.allTrades.tradeDate}</td>
        			<td>{this.props.allTrades.side}</td>
        			<td>{this.props.allTrades.quantity}</td>
        			<td>{this.props.allTrades.price}</td>
        			<td>{this.props.allTrades.counterparty}</td>
        			<td>{this.props.allTrades.location}</td>
        			<td>{this.props.allTrades.status}</td>
        			<td>
        	    		<button type='submit' className="btn btn-primary table-style" value='Submit' onClick={this.onSubmit.bind(this)}>
        	    			<span className="glyphicon glyphicon glyphicon-trash" aria-hidden="true"></span>
        	    		</button>
        	    	</td> 
        		</tr>   	
    }
}