import React from 'react';
import {PhotoDetails} from './PhotoDetails.component';

class Album extends React.Component{
    render(){

        var allpostsInAlbum = this.props.myposts.map((p,index)=>{
            return <PhotoDetails post={p} key={index * Math.random()}></PhotoDetails>
        });

        return <div>           
            <div className="container">
                    {allpostsInAlbum}  

                    </div>         
                    </div>
    }
}

export default Album;