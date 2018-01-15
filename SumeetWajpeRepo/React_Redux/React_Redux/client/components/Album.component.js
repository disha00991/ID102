import React from 'react';
import PhotoDetails from './PhotoDetails';

class Album extends React.Component{
    render(){
        return <div>
                    <h1> Albums here.. </h1>
                    {
                        this.props.myposts.map((post,index)=>{
                            return <PhotoDetails post={post} i={index} key={index} {...this.props} />
                        })
                    }
                   </div>
    }
}

export default Album;
