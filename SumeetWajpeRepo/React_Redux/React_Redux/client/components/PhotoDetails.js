import React from 'react';
import {Link} from 'react-router';

export default class PhotoDetails extends React.Component{
    render(){
        return (    <figure className="grid-figure">
                <div className="grid-photo-wrap">
                    <Link to={`/view/${this.props.post.code}`}>
                    <img src={this.props.post.display_src} 
                        height="100px" width="100px"
                        />
                     </Link>
                </div>
                <figcaption>
                    <p>{this.props.post.caption}</p>
                    <div className="controls-buttons">
                        <button className="likes" 
                    onClick={this.props.increement.bind(null,this.props.i)}>
                            {this.props.post.likes}
                        </button>
                        </div>
                </figcaption>
            </figure>

        );
    }
}