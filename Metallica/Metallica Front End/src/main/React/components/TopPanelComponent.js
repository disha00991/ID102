import React from 'react'; 
 
export default class TopPanel extends React.Component {
	
	handleFormSubmit(){
		   $('#myForm').attr('action', '/logout');
	}
	
    render() {
        return <div className="panel panel-default div-background">
            <div className="panel-body top-background">
                <ul className="nav nav-tabs">
                    <li role="presentation" className="active"><a href="#">TRADES</a></li>
                    <form id="myForm" method="post" className="pull-right">
                    
                    <button type="button" className="btn btn-default btn-sm btn-css-top btn-size">
                        UserName <span className="glyphicon glyphicon-user"></span>
                    </button>
                    &ensp;
                    <button id="your_form" type="submit" className="btn btn-default btn-sm btn-css-top btn-size"
                    	onClick={this.handleFormSubmit.bind(this)}>Logout <span className="glyphicon glyphicon-log-out"></span>
                    	</button>
                    </form>
                </ul>
 
            </div>
        </div>
    }
}
