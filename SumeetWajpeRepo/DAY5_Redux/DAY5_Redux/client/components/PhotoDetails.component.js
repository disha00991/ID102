import React from 'react';

export class PhotoDetails extends React.Component{
    
    render(){
      return  <div className="row postStyle">
            <div className="col-md-2">
                <img src={this.props.post.display_src} height="100%" width="100%"/>
            </div>
            <div className="col-md-4">
            <b>{this.props.post.caption}</b>
            <button type="button" className="btn btn-primary" >&nbsp;{this.props.post.likes}&nbsp;<span className="glyphicon glyphicon-thumbs-up"></span></button>
            </div>
            </div>
    }

}