import React from 'react'
import PureRenderMixin from 'react-addons-pure-render-mixin'
import { Link } from 'react-router'


export default class SingleTicker extends React.Component {
    constructor(props) {
        super(props)
        this.shouldComponentUpdate = PureRenderMixin.shouldComponentUpdate.bind(this)
    }

	render() {
    
        return (<div className="col-md-1">
        <table>
        	<tbody>
	            <tr>{this.props.tickerData.symbol}</tr>
	            <tr>{this.props.tickerData.price}</tr>
	        </tbody>
		</table>
		</div>);
    }
}
