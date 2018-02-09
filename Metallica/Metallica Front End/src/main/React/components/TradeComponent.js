import React from 'react';
import TradeDetails from './TradeDetailsComponent';
import {Link} from 'react-router';

export default class Trade extends React.Component{
	
	constructor(props) {
	    	super(props);
	    
	    	this.state = {
//	    		trades:props.myTrades,
	    		currentPage: 1,
	    		tradesPerPage: 9
	    	};
	    
	    	this.handleClick = this.handleClick.bind(this);
	  }
	
	  handleClick(event) {    
		   this.setState({
	           currentPage: Number(event.target.id)
	       });
	  }
	  
//	  componentWillReceiveProps(props) {
//		  
//		  	 if(this.props.myTrades){
//				  this.setState({trades:this.props.myTrades});
//				  return true
//			 }
//	  }
	
	componentDidMount(){
		console.log("trade");
		console.log(window.location.href);
	}
    
	render(){
		
		var url = window.location.href;
		var urlValue = url 
		console.log(url.includes("search"));
		
		var data;
		if(url.includes("search") == true){
			this.props.mySearchedTrades.map((u,index)=>{
	           console.log(u.commodity);
	        })
	        data=this.props.mySearchedTrades;
		}
		else{
			data=this.props.myTrades;
		}
		
		
		
			 
		const {currentPage, tradesPerPage } = this.state;
		
		const indexOfLastTrade = (currentPage * tradesPerPage);
		const indexOfFirstTrade = indexOfLastTrade - tradesPerPage;
		const currentTrades = data.slice(indexOfFirstTrade, indexOfLastTrade);
	        
        const pageNumbers = [];
		
		for(let i = 1; i <= Math.ceil(data.length / tradesPerPage); i++) {
		        pageNumbers.push(i);
		}
		      
		const renderPageNumbers = pageNumbers.map(number => {
		          return (
		            <button className="btn btn-primary buttonPagination" key={number} id={number} onClick={this.handleClick}>
		              	{number}
		            </button>
		          		);
		      });

		      var allTradeList = currentTrades.map((u,index)=>{
		          return <TradeDetails {...this.props} allTrades={u} i={index} key={index*Math.random()}></TradeDetails>
		})
       
        return <div className="panel panel-default">
		      		<div className="panel-body tradeComponent div-background">
		      			<table className="table table-striped tb div-lightbackground">
						<thead className="thead-dark ">
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
							{allTradeList}					
						</tbody>
					</table> 
				</div>
				<div className="panel-footer">
					{renderPageNumbers}
				</div>	
			</div>	
    }
}