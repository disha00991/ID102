import React from 'react'; 
import {Link} from 'react-router';
import Trade from './TradeComponent';
import {hashHistory} from 'react-router'
 
export default class SearchComponent extends React.Component {

	onClickSearch(e) {
   	 	e.preventDefault();
  	 	var commodity,startDate,endDate,counterParty,location;
  	 	var buyside =$('#buy').is(':checked');
  	 	var sellside =$('#sell').is(':checked');
  	 	var buy,sell;
  	 	if(buyside == false){
  	 		buy = "default";
  	 	}else{
  	 		buy="BUY";
  	 	}
  	 	if(sellside == false){
  	 		sell = "default";
  	 	}else{
  	 		sell="SELL";
  	 	}
	 
	 	if(this.refs.commodity == ""){
	 		commodity="default";
	 	}else{
	 		commodity= this.refs.commodity.value;
	 	}

	 	if(this.refs.startDate.value.length == 0){
	 		startDate="default";
	 	}else{
	 		startDate = this.refs.startDate.value;
	 	}
	 		
	 	if(this.refs.endDate.value.length == 0 ){
	 		endDate="default";
	 	}else{
	 		endDate = this.refs.endDate.value;
	 	}
	 		
	 	if(this.refs.counterParty == undefined){
	 		counterParty="default";
	 	}else{
	 		counterParty = this.refs.counterParty.value;
	 	}
	 	
	 	if(this.refs.location == undefined){
	 		location = "default"
	 	}else{
	 		location = this.refs.location.value;
	 	}
	 	
	 		
// console.log("****"+this.refs.commodity.value);
// if(this.refs.commodity.value == "")
// this.refs.commodity.value="\"\"";
   	 	this.props.fetchSearchedTradeData({
        	commodity: commodity,
        	startDate: startDate,
        	endDate: endDate,
        	buyside: buy,
        	sellside: sell,
        	counterparty: counterParty,
        	location: location
        });
   	    <Trade {...this.props}></Trade>
   	 	hashHistory.push("/search");
    } 
	
	onClickClear(e) {
   	 	e.preventDefault()
   	 	console.log("button");
   	 	$("#new-trade-form").show();
   	 	$("#search-trade-form").trigger("reset");
   	 	hashHistory.push("/");
    } 
	
	
    render() {
    	var location=this.props.myLocations.map((u,index)=>{
            return <option key={index*Math.random()}>{u.name}</option>
        })
        var commodity=this.props.myCommodities.map((u,index)=>{
            return <option key={index*Math.random()}>{u.name}</option>
        })
        var counterParty=this.props.myCounterparties.map((u,index)=>{
            return <option key={index*Math.random()}>{u.name}</option>
        })
        
        var defaultValue="default";
        
        return <div className="panel panel-default div-background">
            		<div className="panel-body">
            			<form className="form-group" id="search-trade-form">
            				<div className="col-md-3">
            						<div className="row">
            						<div className="col-md-7">
            						<label>Trade Date</label>
            						</div>
            						<div className="col-md-3">
						<label>to</label>
						</div>
						</div>
                        
                        <div className="row">
                            <div className="col-md-7">
                                <input type="date" className="form-control date-css" id="tradeFromDate" ref="startDate"></input>
                            </div>
                            
                            <div className="col-md-5">
                                <input type="date" className="form-control date-css" id="tradeToDate" ref="endDate"></input>
                            </div>
                        </div>
                    </div>
                    <div className="col-md-2">
                        <div className="row text-center">
                            <label className="label-css">Commodity</label>
                        </div>
                        <div className="row">
                        <select className="form-control field-css" ref="commodity">
                        <option selected value={defaultValue}> -- select -- </option>
                 			{commodity}
                 			</select>
                        </div>
                    </div>
 
                    <div className="col-md-1">
                        <div className="row text-center">
                            <label className="label-css">SIDE</label>
                        </div>
                        <div className="row">
                        	<div className="col-md-6">
                        		<div  className="chk-css">
                        			<input type="checkbox" id="buy" ref="side1" value="BUY" />
                        		</div>
                            	<label className="chk-label-css">BUY</label>
                            </div>
                            <div className="col-md-6">
                            	<div  className="chk-css">
                            		<input type="checkbox" id="sell" ref="side2" value="SELL" />
                                </div>
                                <label className="chk-label-css">SELL</label>
                            </div>
                        </div>
                    </div>
 
                    <div className="col-md-2 customMargin">
                        <div className="row text-center">
                            <label className="label-css">Counter party</label>
                        </div>
                        <div className="row">
                        <select className="form-control field-css" ref="counterParty">
                        <option selected value={defaultValue}> -- select -- </option>
                 			{counterParty}
                 	  </select>
                        </div>
                    </div>
 
                    <div className="col-md-2">
                        <div className="row text-center">
                            <label className="label-css">Location</label>
                        </div>
                        <div className="row">
                        <select className="form-control field-css" ref="location" >
                        <option selected value={defaultValue}> -- select -- </option>
                 	  		{location}
                 	  </select>
                        </div>
                    </div>
                    <div className="col-md-1">
                        <div className="col-md-6 clearButton">
                            <button type="reset" className="btn btn-css-clear btn-size" onClick={this.onClickClear.bind(this)}>Clear</button>
                        </div>
                        <div className="col-md-6 searchButton">
                        <button className="btn btn-css btn-size" onClick={this.onClickSearch.bind(this)}>
            				Search
            			</button>
                            
                        </div>
                    </div>
                </form>
            </div>
        </div>
    }
}
