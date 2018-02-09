import React from 'react';
import {Link} from 'react-router';
import NewTrade from './NewTradeComponent'
import TopPanel from './TopPanelComponent'
import Search from './SearchComponent'
import Ticker from './TickerComponent'
import TradeNotification from './TradeNotificationComponent'
import {hashHistory} from 'react-router'

export default class Main extends React.Component{

    componentDidMount(){
        this.props.fetchTradeData();
        this.props.fetchCommodityData();
        this.props.fetchLocationData();
        this.props.fetchCounterPartyData(); 
    }
    
    onClickSaveAgain(e) {
   	 	e.preventDefault()
   	 	console.log("button");
   	 	$("#new-trade-form").show();
   	 	$("#new-trade-form").trigger("reset");
	   	 $('#commodity').prop('selected', function() {
	         return this.defaultSelected;
	     });
   	 	hashHistory.push("/");
    } 

    render(){
    	
    	
    	var newTrade = <NewTrade {...this.props}></NewTrade>
    	
    	var topPanel = <TopPanel {...this.props}></TopPanel>
    	var tickerPanel = <Ticker></Ticker>
    	var tradePanel = <TradeNotification></TradeNotification>
    	var search = <Search {...this.props}></Search>
    	
        return <div className="container">
        		
			        <div>
						{topPanel}
					</div>
			        <div>
			        	{tickerPanel}
			        </div>
			        <div>
			        	{tradePanel}
			        </div>
					 <div>
						{search}
					</div>
					<div className="add-btn-position">
						<button className="btn btn-css-add btn-size" onClick={this.onClickSaveAgain.bind(this)}>
		     				Add Trade
		     			</button>
	     			</div>
            		<div className="row">
            			<div className="col-md-8">
	             				{React.cloneElement(this.props.children,this.props)}
            			</div>
            			<div className="col-md-4">
            				{newTrade}
            			</div>
            			
            		</div>
            	</div>
    }
}