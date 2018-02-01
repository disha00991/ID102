import React from 'react';
import SelectedTrade from './SelectedTradeComponent'; 

export default class TradeMapping extends React.Component{
	


    render(){
    	
        var tid = this.props.params.tid;
        
        var index = this.props.myTrades.findIndex((u,i)=>u.tid==tid);
        
        var currTrade = this.props.myTrades.find((u,index)=>{
            
        	if(u.tid==tid)
            return true;
        })

        var currTrade=this.props.myTrades[index];

        return <div>
        <SelectedTrade {...this.props} tradeData={currTrade} i={index}></SelectedTrade>
        </div>
    }
}