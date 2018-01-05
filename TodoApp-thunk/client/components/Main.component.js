import React from 'react';
import { fetchData } from '../actions/actions';
class Main extends React.Component {

    componentWillMount(){
        console.log("comp will mount "+fetchData);
        this.props.fetchData();
    }

    render() {
        return <div>
            <h1> TodoApp </h1>
            {React.cloneElement(this.props.children, this.props)}
        </div>
    }
}

export default Main;