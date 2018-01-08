import React from 'react';
class Main extends React.Component{

    componentDidMount(){
        // this.props.fetchTodosData();
        //action
    }

    render(){
        return <div>
            {/* <h1> {this.props.myTodos.length} </h1>             */}
            {React.cloneElement(this.props.children,this.props)}
                    </div>
    }
}

export default Main;