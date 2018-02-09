import React from 'react';
import {stompClient} from './StompClientComponent';
import PureRenderMixin from 'react-addons-pure-render-mixin'
import SingleTicker from './SingleTickerComponent'
import {TimelineMax} from 'gsap'

export default class Ticker extends React.Component {
	constructor(props){
	    super(props);
	    this.state={tickers:[]};
	}
	
	changeTicker(data){
		 let received = JSON.parse(data.body);
		 this.setState({tickers:received});
	}

	componentDidMount() {
	     stompClient([
	         {
	         route: '/topic/ticker',
	         callback: this.changeTicker.bind(this)
	         }
	     ]);
	
	}

  render() {
		  var ticker = this.state.tickers.map((live,index)=>{
		 	return <SingleTicker tickerData={live} key={index*Math.random()}/>
		 })
  
    return (<div className="panel panel-default ticker-panel div-lightbackground">
        <div className="scroll-left">
        	<div className="tickerClass">
        	
	            
          	{ticker}
          	
          	
          	</div>
        </div>
      </div>);
  }
}