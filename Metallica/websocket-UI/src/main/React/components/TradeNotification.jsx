import React from 'react';
import {stompClient} from './StompClientComponent';
import PureRenderMixin from 'react-addons-pure-render-mixin'
import SingleNotification from './SingleNotification'
import {NotificationContainer, NotificationManager} from 'react-notifications' 




export default class TradeNotification extends React.Component {
	constructor(props){
	    super(props);
	    this.state={message:""};
	}
	
    createNotification(type){
    return () => {
     
    };
  };
	getNotification(data){
	console.log('*********** ---------------------------------'+data);
		 var received = data.body;
		 this.setState({message:received});
         var str=received.split(' ');
         console.log('split done');
         console.log(str[2]);
       
          switch (str[2]) {
        case 'Updated':
        
          NotificationManager.info(received);
          break;
        case 'Created':
        
          NotificationManager.success(received);
          break;
        case 'Deleted':
       
          NotificationManager.error(received);
          break;
       
          default: break;
      }
       
	}

	
	componentDidMount() {
	    console.log(stompClient);
	     stompClient([
	         {route: '/topic/notify', callback: this.getNotification.bind(this)}
	     ]);
	}

  render() {
	
		  var notifyAgain= <NotificationContainer />
  
    return (<div>
        <div id="Notifydiv">
  	       
  	        {notifyAgain}
        </div>
      </div>);
  }
}