import React from 'react';
import {Link} from 'react-router';
import NewTrade from './NewTradeComponent'

export default class Main extends React.Component{
    componentDidMount(){
        this.props.fetchTradeData();
        this.props.fetchCommodityData();
        this.props.fetchLocationData();
        this.props.fetchCounterPartyData();
    }

    
    render(){
    	
    	var newTrade = <NewTrade {...this.props} ></NewTrade>
    	
        return <div className="container">
        
            		
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