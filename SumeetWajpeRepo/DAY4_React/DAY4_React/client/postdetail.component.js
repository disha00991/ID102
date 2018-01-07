
import React  from 'react';  // corrspnd to react folder in node_modules
export class PostDetailComponent extends React.Component{
    render(){
        return <div className="poststyle">
                        <h2>{this.props.postdetails.id}</h2>
                        <p><b> Title : </b>{this.props.postdetails.title}</p>
                        <p><b>Body : </b>{this.props.postdetails.body}</p>                        
                    </div>
    }
}