import React from 'react';
import SelectedTrade from './SelectedTradeComponent'; 

export default class TradeMapping extends React.Component{
	
    render(){
    	
        var tradeId = this.props.params.id;
        var index = this.props.myTrades.findIndex((u,i)=>u.id==tradeId);
//        var currTrade = this.props.myTrades.find((u,index)=>{
//        	if(u.id==tradeId)
//            return true;
//        })
        var currTrade=this.props.myTrades[index];
        console.log('currTrade : ' + currTrade);
        return <div>
        		<SelectedTrade {...this.props} tradeData={currTrade} i={index}></SelectedTrade>
        </div>
    }
}