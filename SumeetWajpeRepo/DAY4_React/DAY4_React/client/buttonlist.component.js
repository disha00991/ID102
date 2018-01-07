
import React  from 'react';  // corrspnd to react folder in node_modules
import ReactDOM from 'react-dom';

import { CustomButtonComponent } from './custombutton.component';
export class ButtonListComponent extends React.Component{
    
    constructor(props){
        super(props);
        this.state = {
            buttonList:this.props.countvalues
        }
    }   

    addItemHandler(){
        let theInputValue = ReactDOM.findDOMNode(this.refs.txtValueFromUser);
            this.setState({buttonList:this.state.buttonList.concat(+(theInputValue.value))});
    }

    render(){
        var buttonsToBeCreated = this.state.buttonList.map((cnt,index)=>{
            return <CustomButtonComponent initialCount={cnt} key={index * Math.random()} />
        });
        return <div>

                <form>
                  Enter a number :  <input type="text" className="form-control" 
                  ref="txtValueFromUser" />
                  <button type="button" className="btn btn-success"                onClick={this.addItemHandler.bind(this)}>Add</button>
                    </form>
                    <br/>


                   {buttonsToBeCreated}
                    </div>
    }
}