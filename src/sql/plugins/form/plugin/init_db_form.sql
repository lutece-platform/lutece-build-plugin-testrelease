--
-- Dumping data for table form_default_message
--
INSERT INTO form_default_message (welcome_message,unavailability_message,requirement_message,recap_message,libelle_validate_button,libelle_reset_button,back_url) VALUES 
('Message de bienvenue','Message d''indisponibilité','Conditions d''utilisation','Message du récapitulatif','Soumettre','','jsp/site/Portal.jsp?page=form');

--
-- Dumping data for table form_entry_type
--
INSERT INTO form_entry_type (id_type,title,is_group,is_comment,class_name) VALUES 
(1,'Bouton radio',false,false,'fr.paris.lutece.plugins.form.business.EntryTypeRadioButton');
INSERT INTO form_entry_type (id_type,title,is_group,is_comment,class_name) VALUES 
(2,'Case à cocher',false,false,'fr.paris.lutece.plugins.form.business.EntryTypeCheckBox');
INSERT INTO form_entry_type (id_type,title,is_group,is_comment,class_name) VALUES 
(3,'Commentaire',false,true,'fr.paris.lutece.plugins.form.business.EntryTypeComment');
INSERT INTO form_entry_type (id_type,title,is_group,is_comment,class_name) VALUES 
(4,'Date',false,false,'fr.paris.lutece.plugins.form.business.EntryTypeDate');
INSERT INTO form_entry_type (id_type,title,is_group,is_comment,class_name) VALUES 
(5,'Liste déroulante',false,false,'fr.paris.lutece.plugins.form.business.EntryTypeSelect');
INSERT INTO form_entry_type (id_type,title,is_group,is_comment,class_name) VALUES 
(6,'Zone de texte court',false,false,'fr.paris.lutece.plugins.form.business.EntryTypeText');
INSERT INTO form_entry_type (id_type,title,is_group,is_comment,class_name) VALUES 
(7,'Zone de texte long',false,false,'fr.paris.lutece.plugins.form.business.EntryTypeTextArea');
INSERT INTO form_entry_type (id_type,title,is_group,is_comment,class_name) VALUES 
(8,'Fichier',false,false,'fr.paris.lutece.plugins.form.business.EntryTypeFile');
INSERT INTO form_entry_type (id_type,title,is_group,is_comment,class_name) VALUES 
(9,'Regroupement',true,false,'fr.paris.lutece.plugins.form.business.EntryTypeGroup');
INSERT INTO form_entry_type (id_type,title,is_group,is_comment,class_name) VALUES
(10,'Liste déroulante SQL',false,false,'fr.paris.lutece.plugins.form.business.EntryTypeSelectSQL');

--
-- Dumping data for table form_action
--
INSERT INTO form_action (id_action,name_key,description_key,action_url,icon_url,action_permission,form_state) VALUES 
(1,'form.action.modify.name','form.action.modify.description','jsp/admin/plugins/form/ModifyForm.jsp','images/admin/skin/plugins/form/actions/modify.png','MODIFY',0);
INSERT INTO form_action (id_action,name_key,description_key,action_url,icon_url,action_permission,form_state) VALUES 
(2,'form.action.modify.name','form.action.modify.description','jsp/admin/plugins/form/ModifyForm.jsp','images/admin/skin/plugins/form/actions/modify.png','MODIFY',1);
INSERT INTO form_action (id_action,name_key,description_key,action_url,icon_url,action_permission,form_state) VALUES 
(3,'form.action.viewRecap.name','form.action.viewRecap.description','jsp/admin/plugins/form/ModifyRecap.jsp','images/admin/skin/plugins/form/actions/recap.png','MODIFY',0);
INSERT INTO form_action (id_action,name_key,description_key,action_url,icon_url,action_permission,form_state) VALUES 
(4,'form.action.viewRecap.name','form.action.viewRecap.description','jsp/admin/plugins/form/ModifyRecap.jsp','images/admin/skin/plugins/form/actions/recap.png','MODIFY',1);
INSERT INTO form_action (id_action,name_key,description_key,action_url,icon_url,action_permission,form_state) VALUES 
(5,'form.action.modifyMessage.name','form.action.modifyMessage.description','jsp/admin/plugins/form/ModifyMessage.jsp','images/admin/skin/plugins/form/actions/message.png','MODIFY',0);
INSERT INTO form_action (id_action,name_key,description_key,action_url,icon_url,action_permission,form_state) VALUES 
(6,'form.action.modifyMessage.name','form.action.modifyMessage.description','jsp/admin/plugins/form/ModifyMessage.jsp','images/admin/skin/plugins/form/actions/message.png','MODIFY',1);
INSERT INTO form_action (id_action,name_key,description_key,action_url,icon_url,action_permission,form_state) VALUES 
(7,'form.action.viewResult.name','form.action.viewResult.description','jsp/admin/plugins/form/Result.jsp','images/admin/skin/plugins/form/actions/response.png','VIEW_RESULT',0);
INSERT INTO form_action (id_action,name_key,description_key,action_url,icon_url,action_permission,form_state) VALUES 
(8,'form.action.viewResult.name','form.action.viewResult.description','jsp/admin/plugins/form/Result.jsp','images/admin/skin/plugins/form/actions/response.png','VIEW_RESULT',1);
INSERT INTO form_action (id_action,name_key,description_key,action_url,icon_url,action_permission,form_state) VALUES 
(9,'form.action.test.name','form.action.test.description','jsp/admin/plugins/form/TestForm.jsp','images/admin/skin/plugins/form/actions/test.png','TEST',0);
INSERT INTO form_action (id_action,name_key,description_key,action_url,icon_url,action_permission,form_state) VALUES 
(10,'form.action.test.name','form.action.test.description','jsp/admin/plugins/form/TestForm.jsp','images/admin/skin/plugins/form/actions/test.png','TEST',1);
INSERT INTO form_action (id_action,name_key,description_key,action_url,icon_url,action_permission,form_state) VALUES 
(11,'form.action.disable.name','form.action.disable.description','jsp/admin/plugins/form/ConfirmDisableForm.jsp','images/admin/skin/plugins/form/actions/disable.png','CHANGE_STATE',1);
INSERT INTO form_action (id_action,name_key,description_key,action_url,icon_url,action_permission,form_state) VALUES 
(12,'form.action.enable.name','form.action.enable.description','jsp/admin/plugins/form/DoEnableForm.jsp','images/admin/skin/plugins/form/actions/enable.png','CHANGE_STATE',0);
INSERT INTO form_action (id_action,name_key,description_key,action_url,icon_url,action_permission,form_state) VALUES 
(13,'form.action.copy.name','form.action.copy.description','jsp/admin/plugins/form/DoCopyForm.jsp','images/admin/skin/plugins/form/actions/editcopy.png','COPY',0);
INSERT INTO form_action (id_action,name_key,description_key,action_url,icon_url,action_permission,form_state) VALUES 
(14,'form.action.copy.name','form.action.copy.description','jsp/admin/plugins/form/DoCopyForm.jsp','images/admin/skin/plugins/form/actions/editcopy.png','COPY',1);
INSERT INTO form_action (id_action,name_key,description_key,action_url,icon_url,action_permission,form_state) VALUES 
(15,'form.action.manageOutputProcessor.name','form.action.manageOutputProcessor.description','jsp/admin/plugins/form/ManageOutputProcessor.jsp','images/admin/skin/plugins/form/actions/processor.png','MANAGE_OUTPUT_PROCESSOR',1);	
INSERT INTO form_action (id_action,name_key,description_key,action_url,icon_url,action_permission,form_state) VALUES 
(16,'form.action.manageOutputProcessor.name','form.action.manageOutputProcessor.description','jsp/admin/plugins/form/ManageOutputProcessor.jsp','images/admin/skin/plugins/form/actions/processor.png','MANAGE_OUTPUT_PROCESSOR',0);
INSERT INTO form_action (id_action,name_key,description_key,action_url,icon_url,action_permission,form_state) VALUES 
(17,'form.action.delete.name','form.action.delete.description','jsp/admin/plugins/form/ConfirmRemoveForm.jsp','images/admin/skin/plugins/form/actions/delete.png','DELETE',0);
INSERT INTO form_action (id_action,name_key,description_key,action_url,icon_url,action_permission,form_state) VALUES 
(18,'form.action.disable.name','form.action.disableAuto.description','jsp/admin/plugins/form/ConfirmDisableAutoForm.jsp','images/admin/skin/plugins/form/actions/pause_auto_publication.png','CHANGE_STATE_AUTO_PUBLICATION',1);
INSERT INTO form_action (id_action,name_key,description_key,action_url,icon_url,action_permission,form_state) VALUES 
(19,'form.action.enable.name','form.action.enableAuto.description','jsp/admin/plugins/form/DoEnableAutoForm.jsp','images/admin/skin/plugins/form/actions/enable_auto_publication.png','CHANGE_STATE_AUTO_PUBLICATION',0);

--
-- Dumping data for table form_graph_type
--
INSERT INTO form_graph_type (id_graph_type,title,class_name) VALUES 
(1,'Histogramme','fr.paris.lutece.plugins.form.business.GraphTypeBarChart');
INSERT INTO form_graph_type (id_graph_type,title,class_name) VALUES 
(2,'Camembert','fr.paris.lutece.plugins.form.business.GraphTypePieChart');

--
-- Dumping data for table form_export_format
--
INSERT INTO form_export_format (id_export,title,description,extension,xsl_file) VALUES 
(1,'csv','exporter les réponses au format csv','csv',0x3C3F786D6C2076657273696F6E3D22312E302220656E636F64696E673D2249534F2D383835392D31223F3E0D0A3C78736C3A7374796C6573686565742076657273696F6E3D22312E302220786D6C6E733A78736C3D22687474703A2F2F7777772E77332E6F72672F313939392F58534C2F5472616E73666F726D223E0D0A3C78736C3A6F7574707574206D6574686F643D2274657874222F3E0D0A3C78736C3A74656D706C617465206D617463683D222F223E0D0A203C78736C3A6170706C792D74656D706C617465732073656C6563743D22666F726D2F7375626D6974732F7375626D6974222F3E200D0A3C2F78736C3A74656D706C6174653E0D0A0D0A3C78736C3A74656D706C617465206D617463683D22666F726D2F7375626D6974732F7375626D6974223E3C78736C3A696620746573743D22706F736974696F6E28293D31223E0D0A2020202020203C78736C3A6170706C792D74656D706C617465732073656C6563743D227175657374696F6E732F7175657374696F6E222F3E200D0A09202020203C78736C3A746578743E262331303B3C2F78736C3A746578743E0D0A2020203C2F78736C3A69663E0D0A2020203C78736C3A6170706C792D74656D706C617465732073656C6563743D227175657374696F6E732F7175657374696F6E2F726573706F6E736573222F3E200D0A09202020203C78736C3A746578743E262331303B3C2F78736C3A746578743E0D0A200D0A203C2F78736C3A74656D706C6174653E0D0A090D0A203C78736C3A74656D706C617465206D617463683D227175657374696F6E732F7175657374696F6E223E223C78736C3A76616C75652D6F662073656C6563743D227175657374696F6E2D7469746C65222F3E200D0A093C78736C3A746578743E223B3C2F78736C3A746578743E0D0A3C2F78736C3A74656D706C6174653E0D0A200D0A203C78736C3A74656D706C617465206D617463683D227175657374696F6E732F7175657374696F6E2F726573706F6E736573223E0D0A093C78736C3A746578743E223C2F78736C3A746578743E0D0A09093C78736C3A6170706C792D74656D706C617465732073656C6563743D22726573706F6E7365222F3E0D0A093C78736C3A746578743E223B3C2F78736C3A746578743E0D0A093C2F78736C3A74656D706C6174653E0D0A3C78736C3A74656D706C617465206D617463683D227175657374696F6E732F7175657374696F6E2F726573706F6E7365732F726573706F6E7365223E0D0A09203C78736C3A76616C75652D6F662073656C6563743D222E222F3E0D0A0920203C78736C3A696620746573743D22706F736974696F6E2829213D6C6173742829223E0D0A09093C78736C3A746578743E3B3C2F78736C3A746578743E0D0A0920203C2F78736C3A69663E0D0A203C2F78736C3A74656D706C6174653E0D0A203C2F78736C3A7374796C6573686565743E);
INSERT INTO form_export_format (id_export,title,description,extension,xsl_file) VALUES 
(2,'xml','exporter les réponses au format xml','xml',0x3C3F786D6C2076657273696F6E3D22312E302220656E636F64696E673D2249534F2D383835392D31223F3E0D0A3C78736C3A7374796C6573686565742076657273696F6E3D22312E302220786D6C6E733A78736C3D22687474703A2F2F7777772E77332E6F72672F313939392F58534C2F5472616E73666F726D223E0D0A3C78736C3A6F7574707574206D6574686F643D22786D6C222076657273696F6E3D22312E302220656E636F64696E673D2249534F2D383835392D312220696E64656E743D22796573222063646174612D73656374696F6E2D656C656D656E74733D22726573706F6E7365207175657374696F6E2D7469746C6520666F726D2D7469746C65222F3E0D0A3C78736C3A74656D706C617465206D617463683D222F223E0D0A203C78736C3A6170706C792D74656D706C617465732073656C6563743D22666F726D222F3E200D0A3C2F78736C3A74656D706C6174653E0D0A0D0A3C78736C3A74656D706C617465206D617463683D22666F726D223E0D0A093C666F726D3E0D0A09093C666F726D2D7469746C653E0D0A0909093C78736C3A76616C75652D6F662073656C6563743D22666F726D2D7469746C65222F3E0D0A09093C2F666F726D2D7469746C653E0D0A09093C7375626D6974733E0D0A0909093C78736C3A6170706C792D74656D706C617465732073656C6563743D227375626D6974732F7375626D6974222F3E200D0A09093C2F7375626D6974733E0D0A093C2F666F726D3E090D0A3C2F78736C3A74656D706C6174653E0D0A0D0A3C78736C3A74656D706C617465206D617463683D227375626D6974223E0D0A093C7375626D69743E0D0A09093C7375626D69742D69643E0D0A0909093C78736C3A76616C75652D6F662073656C6563743D227375626D69742D6964222F3E0D0A09093C2F7375626D69742D69643E0D0A09093C7375626D69742D646174653E0D0A0909093C78736C3A76616C75652D6F662073656C6563743D227375626D69742D64617465222F3E0D0A09093C2F7375626D69742D646174653E0D0A09093C7375626D69742D69703E0D0A0909093C78736C3A76616C75652D6F662073656C6563743D227375626D69742D6970222F3E0D0A09093C2F7375626D69742D69703E0D0A09093C7175657374696F6E733E0D0A0909093C78736C3A6170706C792D74656D706C617465732073656C6563743D227175657374696F6E732F7175657374696F6E222F3E200D0A09093C2F7175657374696F6E733E0D0A093C2F7375626D69743E0D0A3C2F78736C3A74656D706C6174653E0D0A3C78736C3A74656D706C617465206D617463683D227175657374696F6E223E0D0A093C7175657374696F6E3E0D0A09093C7175657374696F6E2D7469746C653E0D0A0909093C78736C3A76616C75652D6F662073656C6563743D227175657374696F6E2D7469746C65222F3E0D0A09093C2F7175657374696F6E2D7469746C653E0D0A09093C726573706F6E7365733E0D0A0909093C78736C3A6170706C792D74656D706C617465732073656C6563743D22726573706F6E7365732F726573706F6E7365222F3E200D0A09093C2F726573706F6E7365733E0D0A093C2F7175657374696F6E3E0D0A3C2F78736C3A74656D706C6174653E0D0A3C78736C3A74656D706C617465206D617463683D22726573706F6E7365223E0D0A093C726573706F6E73653E0D0A09093C78736C3A76616C75652D6F662073656C6563743D222E222F3E0D0A093C2F726573706F6E73653E0D0A3C2F78736C3A74656D706C6174653E0D0A3C2F78736C3A7374796C6573686565743E);

--
-- a form example
--

-- register an exemple form
INSERT INTO form_recap (id_recap, back_url, id_graph_type, recap_message, recap_data, graph, graph_three_dimension, graph_legende, graph_value_legende, graph_label) VALUES (1,'jsp/site/Portal.jsp',2,'Merci pour vos réponses.',1,1,1,0,NULL,1);
INSERT INTO form_form (id_form, title, description, welcome_message, unavailability_message, requirement_message, workgroup, id_mailing_list, active_captcha, active_store_adresse, libelle_validate_button, libelle_reset_button, date_begin_disponibility, date_end_disponibility, active, auto_publication, date_creation, limit_number_response, id_recap, active_requirement) VALUES (1,'Qu''attendez vous d''un CMS open-source ?','Décrivez nous vos attentes pour un CMS open-source.','<p>Les réponses seront effacées toutes les heures environ.\r\n</p>\r\n<p>Les choix par défaut sont ceux retenus pour Lutece.\r\n</p>','Le formulaire n''est plus disponible.','Les réponses seront effacées toutes les 3 heures environ.\r\n<br />','all',0,0,1,'Soumettre','Réinitialiser',NULL,NULL,1,0,'2009-06-16 10:49:31',0,1,0);

-- register entries for the exemple form
INSERT INTO form_entry (id_entry, id_form, id_type, id_parent, title, help_message, comment, mandatory, fields_in_line, pos, id_field_depend, confirm_field, confirm_field_title, field_unique) VALUES (1,1,1,2,'Quelle licence préférez vous ?','','',0,0,2,NULL,NULL,NULL,NULL);
INSERT INTO form_entry (id_entry, id_form, id_type, id_parent, title, help_message, comment, mandatory, fields_in_line, pos, id_field_depend, confirm_field, confirm_field_title, field_unique) VALUES (2,1,9,NULL,'Qu''attendez vous d''un CMS open-source ?',NULL,NULL,0,0,1,NULL,NULL,NULL,NULL);
INSERT INTO form_entry (id_entry, id_form, id_type, id_parent, title, help_message, comment, mandatory, fields_in_line, pos, id_field_depend, confirm_field, confirm_field_title, field_unique) VALUES (3,1,6,NULL,'Si autre merci de préciser.','','',0,0,3,7,NULL,NULL,NULL);
INSERT INTO form_entry (id_entry, id_form, id_type, id_parent, title, help_message, comment, mandatory, fields_in_line, pos, id_field_depend, confirm_field, confirm_field_title, field_unique) VALUES (4,1,2,2,'Quel éditeur pour ajouter vos contenus ?','','',0,0,3,NULL,NULL,NULL,NULL);
INSERT INTO form_entry (id_entry, id_form, id_type, id_parent, title, help_message, comment, mandatory, fields_in_line, pos, id_field_depend, confirm_field, confirm_field_title, field_unique) VALUES (5,1,5,2,'Quelle accessibilité pour votre CMS ?','','',0,0,3,NULL,NULL,NULL,NULL);
INSERT INTO form_entry (id_entry, id_form, id_type, id_parent, title, help_message, comment, mandatory, fields_in_line, pos, id_field_depend, confirm_field, confirm_field_title, field_unique) VALUES (6,1,1,2,'Quelle communauté pour votre CMS ?','','',0,0,3,NULL,NULL,NULL,NULL);
INSERT INTO form_entry (id_entry, id_form, id_type, id_parent, title, help_message, comment, mandatory, fields_in_line, pos, id_field_depend, confirm_field, confirm_field_title, field_unique) VALUES (7,1,2,2,'Quelle base de donnée pour votre CMS ?','','',0,0,3,NULL,NULL,NULL,NULL);
INSERT INTO form_entry (id_entry, id_form, id_type, id_parent, title, help_message, comment, mandatory, fields_in_line, pos, id_field_depend, confirm_field, confirm_field_title, field_unique) VALUES (8,1,7,2,'Autre','','',0,0,4,NULL,NULL,NULL,NULL);

INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (1,1,'GPL (GNU General Public License).','gpl',0,0,0,0,1,NULL,NULL);
INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (2,1,'LGPL (Lesser General Public License).','lgpl',0,0,0,0,2,NULL,NULL);
INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (24,1,'Apache License','ApacheLicense',0,0,0,0,7,NULL,0);
INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (25,5,'RGAA A','RGAA A',0,0,0,0,25,NULL,0);
INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (6,1,'BSD License.','bsd',0,0,1,0,6,NULL,NULL);
INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (7,1,'Autre','autre',0,0,0,0,24,NULL,0);
INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (8,3,NULL,'',0,43,0,-1,8,NULL,NULL);
INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (9,4,'Syntaxe wiki','wiki',0,0,0,0,9,NULL,NULL);
INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (10,4,'Editeur riche (wysiwyg)','wysiwyg',0,0,1,0,10,NULL,NULL);
INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (11,4,'Html/Css/Javascript','html',0,0,1,0,11,NULL,NULL);
INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (12,5,'Aucune contrainte','empty',0,0,0,0,12,NULL,NULL);
INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (27,5,'RGAA AAA','RGAA AAA',0,0,0,0,27,NULL,0);
INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (26,5,'RGAA AA','RGAA AA',0,0,1,0,26,NULL,0);
INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (16,6,'Offre avec double licence libre/payant','entreprise',0,0,0,0,16,NULL,NULL);
INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (17,6,'Une communauté de SSII et collectivités','lutece',0,0,1,0,17,NULL,NULL);
INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (18,6,'Je préfère ne pas savoir','none',0,0,0,0,18,NULL,NULL);
INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (19,7,'MySql','MySql',0,0,1,0,19,NULL,NULL);
INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (20,7,'Oracle','oracle',0,0,1,0,20,NULL,NULL);
INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (21,7,'Postgre','postgre',0,0,1,0,21,NULL,NULL);
INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (22,8,NULL,'',4,26,0,0,22,NULL,NULL);
INSERT INTO form_field (id_field, id_entry, title, value, height, width, default_value, max_size_enter, pos, value_type_date, no_display_title) VALUES (23,7,'SqlServer (Microsoft)','sqlserver',0,0,0,0,23,NULL,NULL);

-- add the exemple form in a portlet
INSERT INTO core_portlet (id_portlet, id_portlet_type, id_page, name, date_update, status, portlet_order, column_no, id_style, accept_alias, date_creation, display_portlet_title) VALUES (94,'FORM_PORTLET',11,'Questionnaire','2009-06-16 12:55:48',0,1,1,1500,1,'2009-06-16 12:55:48',1);
INSERT INTO form_portlet (id_portlet, id_form) VALUES (94,1);
