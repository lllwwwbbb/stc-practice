import React, {Component, PropTypes} from 'react';

import {Row, Col, Card, Tabs, Select, Button, Layout, Form, Input} from 'antd';
const { Header, Sider, Content } = Layout;
const FormItem = Form.Item;
const Option = Select.Option;
let isDisabled = false;

import SubItemContainer from 'common/basic/containers/SubItemContainer';

import OrganizationTreeContainer from 'routes/System/containers/OrganizationTreeContainer';
import UserListView from './UserListView';

export default class UserTreeView extends Component
{
	constructor(props)
	{
		super(props);

		this.state = 
		{
			organizationId: ''
		}
	}

	setOrganizationId = (organizationId) =>
	{
		this.setState(
		{
			organizationId: organizationId
		});
	}

	/*static defaultProps = {
		company:'贪玩蓝月',
		telephone:'110',
		weituo:1
	}*/

	render(){
			return(
				<Form layout='vertical'>
					<Card title='委托信息'>
						<Row>
						<Col span={12}>
							<FormItem label="委托单位">
								<Input  onChange={this.props.company} defaultValue="江西贪玩技术有限公司" />
							</FormItem>
						</Col>
						<Col span={12}>
							<FormItem label="联系电话">
								<Input  onChange={this.props.telephone} defaultValue="40062-33555" />
							</FormItem>
						</Col>
						</Row>
					</Card>
					<FormItem>
					</FormItem>
					<FormItem>
						<div>
							<Row gutter={16}>
								<Col span={6}></Col>
								<Col span={6} offset={2}><Button type="primary" disabled={isDisabled}>提交</Button></Col>
								<Col span={6}><Button htmlType="deny" disabled={isDisabled}>保存</Button></Col>
								<Col span={6}></Col>
							</Row>
						</div>
					</FormItem>
				</Form>
			); //this.renderForm(formItems);
		}

	/*render()
	{
		const minHeight = '850px';

		const userStoreName = 'user';
		const _UserListView = SubItemContainer(userStoreName, UserListView);			
		render(
			<Row gutter={16}>
				<Col span={8}>
					<Card title='委托单位' style={{minHeight: minHeight}}>
						<OrganizationTreeContainer setParentId={(organizationId) => this.setOrganizationId(organizationId)}/>
					</Card>
				</Col>
				<Col span={16}>
					<Card title='联系电话' style={{minHeight: minHeight}}>
						<_UserListView storeName={userStoreName} parentId={this.state.organizationId} />
					</Card>
				</Col>
			</Row>
		);
	}*/
}

