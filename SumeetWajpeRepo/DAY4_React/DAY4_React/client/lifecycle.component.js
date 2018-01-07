
import React  from 'react';  // corrspnd to react folder in node_modules
import ReactDOM from 'react-dom';

export class LifeCycleComponent extends React.Component{

    constructor(props){
        super(props);
        
    }

    componentWillMount(){
        // set the Initial State !
        this.state = {companyName:''}
        console.log('component Will Mount called !');
    }

    componentDidMount(){
        // make ajax requests ! access DOM !
        console.log('component Did Mount called !');        
    }

    shouldComponentUpdate(){
        console.log('should Component Update called !');
        if(arguments[1].companyName.length > 5){
            console.log(arguments[1].companyName)
            return false;
        }
        return true;
        
    }

    componentWillUpdate(){
        console.log('Component Will Update called !');        
    }

    componentDidUpdate(){
        console.log('Component Did Update called !');        
    }
    



    onChangeHandler(){
        let txtInput = ReactDOM.findDOMNode(this.refs.txtCompany);
        this.setState({companyName:txtInput.value});
    }

    render(){
        console.log('Render called !');

        return (<div>
                    <form>
                        <lable>Company Name : </lable>
                        <input type="text" ref="txtCompany" 
                        onChange={this.onChangeHandler.bind(this)} />
                        <lable>{this.state.companyName}</lable>
                        </form>
                    </div>)
    }
}