--
-- Dumping data for table core_admin_right
--
INSERT INTO core_admin_right (id_right,name,level_right,admin_url,description,is_updatable,plugin_name,id_feature_group,icon_url,documentation_url) VALUES 
('FORM_MANAGEMENT','form.adminFeature.form_management.name',2,'jsp/admin/plugins/form/ManagePluginForm.jsp','form.adminFeature.form_management.description',0,'form','APPLICATIONS','images/admin/skin/plugins/form/form.png','jsp/admin/documentation/AdminDocumentation.jsp?doc=admin-form');

--
-- Dumping data for table core_style
--
INSERT INTO core_style (id_style,description_style,id_portlet_type,id_portal_component) VALUES 
(1500,'Défaut','FORM_PORTLET',0);

--
-- Dumping data for table core_style_mode_stylesheet
--
INSERT INTO core_style_mode_stylesheet (id_style,id_mode,id_stylesheet) VALUES 
(1500,0,1500);

--
-- Dumping data for table core_stylesheet
--
INSERT INTO core_stylesheet (id_stylesheet,description,file_name,source) VALUES 
(1500,'Rubrique de formulaire','portlet_form.xsl',0x3C3F786D6C2076657273696F6E3D22312E30223F3E0D0A3C78736C3A7374796C6573686565742076657273696F6E3D22312E302220786D6C6E733A78736C3D22687474703A2F2F7777772E77332E6F72672F313939392F58534C2F5472616E73666F726D223E0D0A3C78736C3A6F7574707574206D6574686F643D2268746D6C2220696E64656E743D22796573222F3E0D0A3C78736C3A74656D706C617465206D617463683D22706F72746C6574223E0D0A093C64697620636C6173733D22706F72746C6574202D6C75746563652D626F726465722D72616469757320617070656E642D626F74746F6D223E0D0A09093C78736C3A6170706C792D74656D706C617465732073656C6563743D22666F726D2D706F72746C657422202F3E0D0A093C2F6469763E0D0A3C2F78736C3A74656D706C6174653E0D0A0D0A3C78736C3A74656D706C617465206D617463683D22666F726D2D706F72746C6574223E0D0A093C78736C3A6170706C792D74656D706C617465732073656C6563743D22666F726D2D706F72746C65742D636F6E74656E7422202F3E0D0A3C2F78736C3A74656D706C6174653E0D0A0D0A3C78736C3A74656D706C617465206D617463683D22666F726D2D706F72746C65742D636F6E74656E74223E0D0A093C78736C3A76616C75652D6F662064697361626C652D6F75747075742D6573636170696E673D22796573222073656C6563743D222E22202F3E0D0A3C2F78736C3A74656D706C6174653E0D0A0D0A3C2F78736C3A7374796C6573686565743E);

--
-- Dumping data for table core_portlet_type
--
INSERT INTO core_portlet_type (id_portlet_type,name,url_creation,url_update,home_class,plugin_name,url_docreate,create_script,create_specific,create_specific_form,url_domodify,modify_script,modify_specific,modify_specific_form) VALUES 
('FORM_PORTLET','form.portlet.name','plugins/form/CreateFormPortlet.jsp','plugins/form/ModifyFormPortlet.jsp','fr.paris.lutece.plugins.form.business.portlet.FormPortletHome','form','plugins/form/DoCreateFormPortlet.jsp','','/admin/plugins/form/list_form.html','','plugins/form/DoModifyFormPortlet.jsp','','/admin/plugins/form/list_form.html','');


--
-- Dumping data for table core_user_right
--
INSERT INTO core_user_right (id_right,id_user) VALUES ('FORM_MANAGEMENT',1);
INSERT INTO core_user_right (id_right,id_user) VALUES ('FORM_MANAGEMENT',2);

--
-- Dumping data for table core_admin_role
--
INSERT INTO core_admin_role (role_key,role_description) VALUES ('form_manager','Gestion des formulaires');
INSERT INTO core_admin_role (role_key,role_description) VALUES ('form_manager_admin','Administration des formulaires');

--
-- Dumping data for table core_admin_role_resource
--
INSERT INTO core_admin_role_resource (rbac_id,role_key,resource_type,resource_id,permission) VALUES 
 (905,'form_manager_admin','FORM_EXPORT_FORMAT_TYPE','*','*');
INSERT INTO core_admin_role_resource (rbac_id,role_key,resource_type,resource_id,permission) VALUES  
 (906,'form_manager_admin','FORM_DEFAULT_MESSAGE_TYPE','*','*');
 INSERT INTO core_admin_role_resource (rbac_id,role_key,resource_type,resource_id,permission) VALUES 
 (907,'form_manager','FORM_FORM_TYPE','*','*');

--
-- Dumping data for table core_user_role
--
INSERT INTO core_user_role (role_key,id_user) VALUES ('form_manager_admin',1);
INSERT INTO core_user_role (role_key,id_user) VALUES ('form_manager',1);
INSERT INTO core_user_role (role_key,id_user) VALUES ('form_manager',2);
