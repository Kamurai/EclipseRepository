drop table apples;
commit;
CREATE TABLE apples ( id number, name varchar2(255), price float, picurl varchar2(255) );
commit;


INSERT INTO APPLES VALUES( 0, 'Lady', 1.25, 'https://www.prevention.com/sites/prevention.com/files/styles/listicle_slide_custom_user_desktop_1x/public/comp-3596329-lady-ryo-takemasa.jpg?itok=vDHKTpyH' );
INSERT INTO APPLES VALUES( 1, 'Baldwin', 1.25, 'https://www.prevention.com/sites/prevention.com/files/styles/listicle_slide_custom_user_tablet_1x/public/comp-3593268-baldwin-ryo-takemasa.jpg?itok=TRaV05mk' );
INSERT INTO APPLES VALUES( 2, 'Gravenstein', 1.25, 'https://www.prevention.com/sites/prevention.com/files/styles/listicle_slide_custom_user_tablet_1x/public/comp-3593283-gravenstein-ryo-takemasa.jpg?itok=UhJSLUNw' );
INSERT INTO APPLES VALUES( 3, 'McIntosh', 1.25, 'https://www.prevention.com/sites/prevention.com/files/styles/listicle_slide_custom_user_tablet_1x/public/comp-3593287-mcintosh-ryo-takemasa.jpg?itok=u1bJHr9S' );
INSERT INTO APPLES VALUES( 4, 'Cox Orange Pippin', 1.25, 'https://www.prevention.com/sites/prevention.com/files/styles/listicle_slide_custom_user_tablet_1x/public/comp-3596328-coxs-orange-pippin-ryo-takemasa.jpg?itok=AXzFG_IW' );
INSERT INTO APPLES VALUES( 5, 'Northern Spy', 1.25, 'https://www.prevention.com/sites/prevention.com/files/styles/listicle_slide_custom_user_tablet_1x/public/comp-3593289-northern-spy-ryo-takemasa.jpg?itok=R8uyzlNf' );
INSERT INTO APPLES VALUES( 6, 'Cortland', 1.25, 'https://www.prevention.com/sites/prevention.com/files/styles/listicle_slide_custom_user_tablet_1x/public/comp-3593269-cortland-ryo-takemasa.jpg?itok=tgDVk3T3' );
INSERT INTO APPLES VALUES( 7, 'Mutsu', 1.25, 'https://www.prevention.com/sites/prevention.com/files/styles/listicle_slide_custom_user_tablet_1x/public/comp-3593288-mutsu-ryo-takemasa.jpg?itok=4s_L27-R' );
INSERT INTO APPLES VALUES( 8, 'Ginger Gold', 1.25, 'https://www.prevention.com/sites/prevention.com/files/styles/listicle_slide_custom_user_tablet_1x/public/comp-3593271-ginger-gold-ryo-takemasa.jpg?itok=R8oZZU0k' );
INSERT INTO APPLES VALUES( 9, 'Honeycrisp', 1.25, 'https://www.prevention.com/sites/prevention.com/files/styles/listicle_slide_custom_user_tablet_1x/public/comp-3593284-honeycrisp-ryo-takemasa.jpg?itok=IGaWZx0Q' );
INSERT INTO APPLES VALUES( 10, 'Liberty', 1.25, 'https://www.prevention.com/sites/prevention.com/files/styles/listicle_slide_custom_user_tablet_1x/public/comp-3593286-liberty-ryo-takemasa.jpg?itok=0Yn_36YD' );
INSERT INTO APPLES VALUES( 11, 'Pink Lady', 1.25, 'https://www.prevention.com/sites/prevention.com/files/styles/listicle_slide_custom_user_tablet_1x/public/comp-3593290-pink-lady-ryo-takemasa.jpg?itok=-JwAvNff' );
INSERT INTO APPLES VALUES( 12, 'Goldrush', 1.25, 'https://www.prevention.com/sites/prevention.com/files/styles/listicle_slide_custom_user_tablet_1x/public/comp-3593282-goldrush-ryo-takemasa.jpg?itok=YlBrjUJQ' );
INSERT INTO APPLES VALUES( 13, 'Rubyfrost', 1.25, 'https://www.prevention.com/sites/prevention.com/files/styles/listicle_slide_custom_user_tablet_1x/public/comp-3593291-rubyfrost-ryo-takemasa.jpg?itok=EVbP49jP' );
INSERT INTO APPLES VALUES( 14, 'Snapdragon', 1.25, 'https://www.prevention.com/sites/prevention.com/files/styles/listicle_slide_custom_user_tablet_1x/public/comp-3593302-snapdragon-ryo-takemasa.jpg?itok=-VHgfO93' );
COMMIT;



select * from apples;
