import React from 'react';
import PhotoDetails from './PhotoDetails';


class Photo extends React.Component{
    render(){

        // fetch the parameter from URL !
        
        var code = this.props.params.id;        
        const index = this.props.myposts.findIndex((post) =>
            post.code === code );
        const currPost = this.props.myposts[index];

        return <div>
                          <PhotoDetails post={currPost} {...this.props} i={index}  />  
                   </div>
    }
}

export default Photo;
