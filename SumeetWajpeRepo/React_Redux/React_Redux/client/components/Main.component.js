import React from 'react';

class Main extends React.Component{
    componentWillMount(){
        this.props.fetchData();
    }
    render(){
        return <div>             
            <b>{this.props.fetchposts.length}</b>
                    {React.cloneElement(this.props.children,this.props)}
                   </div>
    }
}

export default Main;
