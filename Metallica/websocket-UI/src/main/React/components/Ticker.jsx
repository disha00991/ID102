import React from 'react';
import {stompClient} from './StompClientComponent';
import PureRenderMixin from 'react-addons-pure-render-mixin'
import SingleTicker from './SingleTicker'

export default class Ticker extends React.Component {
	constructor(props){
	    super(props);
	    this.state={tickers:[]};
	}
	
	changeTicker(data){
		 let received = JSON.parse(data.body);
		 console.log('element : --------------------------------- ' + received);
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
  
    return (<div>
        <div className="scroll-left">
        	<div className="tickerClass">
          	{ticker}
          	</div>
        </div>
      </div>);
  }
}