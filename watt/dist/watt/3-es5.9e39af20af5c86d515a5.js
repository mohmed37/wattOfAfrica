function _toConsumableArray(e){return _arrayWithoutHoles(e)||_iterableToArray(e)||_unsupportedIterableToArray(e)||_nonIterableSpread()}function _nonIterableSpread(){throw new TypeError("Invalid attempt to spread non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}function _unsupportedIterableToArray(e,t){if(e){if("string"==typeof e)return _arrayLikeToArray(e,t);var n=Object.prototype.toString.call(e).slice(8,-1);return"Object"===n&&e.constructor&&(n=e.constructor.name),"Map"===n||"Set"===n?Array.from(e):"Arguments"===n||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)?_arrayLikeToArray(e,t):void 0}}function _iterableToArray(e){if("undefined"!=typeof Symbol&&Symbol.iterator in Object(e))return Array.from(e)}function _arrayWithoutHoles(e){if(Array.isArray(e))return _arrayLikeToArray(e)}function _arrayLikeToArray(e,t){(null==t||t>e.length)&&(t=e.length);for(var n=0,i=new Array(t);n<t;n++)i[n]=e[n];return i}function _inherits(e,t){if("function"!=typeof t&&null!==t)throw new TypeError("Super expression must either be null or a function");e.prototype=Object.create(t&&t.prototype,{constructor:{value:e,writable:!0,configurable:!0}}),t&&_setPrototypeOf(e,t)}function _setPrototypeOf(e,t){return(_setPrototypeOf=Object.setPrototypeOf||function(e,t){return e.__proto__=t,e})(e,t)}function _createSuper(e){var t=_isNativeReflectConstruct();return function(){var n,i=_getPrototypeOf(e);if(t){var r=_getPrototypeOf(this).constructor;n=Reflect.construct(i,arguments,r)}else n=i.apply(this,arguments);return _possibleConstructorReturn(this,n)}}function _possibleConstructorReturn(e,t){return!t||"object"!=typeof t&&"function"!=typeof t?_assertThisInitialized(e):t}function _assertThisInitialized(e){if(void 0===e)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return e}function _isNativeReflectConstruct(){if("undefined"==typeof Reflect||!Reflect.construct)return!1;if(Reflect.construct.sham)return!1;if("function"==typeof Proxy)return!0;try{return Date.prototype.toString.call(Reflect.construct(Date,[],(function(){}))),!0}catch(e){return!1}}function _getPrototypeOf(e){return(_getPrototypeOf=Object.setPrototypeOf?Object.getPrototypeOf:function(e){return e.__proto__||Object.getPrototypeOf(e)})(e)}function _classCallCheck(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}function _defineProperties(e,t){for(var n=0;n<t.length;n++){var i=t[n];i.enumerable=i.enumerable||!1,i.configurable=!0,"value"in i&&(i.writable=!0),Object.defineProperty(e,i.key,i)}}function _createClass(e,t,n){return t&&_defineProperties(e.prototype,t),n&&_defineProperties(e,n),e}(window.webpackJsonp=window.webpackJsonp||[]).push([[3],{ANEU:function(e,t,n){"use strict";n.d(t,"a",(function(){return s}));var i=n("fXoL"),r=n("tk/3"),a=n("ej43"),o=n("H+bZ"),s=function(){var e=function(){function e(t,n,i){_classCallCheck(this,e),this.htttpClient=t,this.userConnect=n,this.hostTestService=i,this.hostTest=i.TEST_MICRO_APP}return _createClass(e,[{key:"saveListMetierClient",value:function(e,t){return this.htttpClient.post(e,t.valueOf())}},{key:"modifListMetierClient",value:function(e,t){return this.htttpClient.put(e,t.valueOf())}},{key:"getFicheMetierClient",value:function(){return this.htttpClient.get(this.hostTest+"/getMetierByClient/"+this.userConnect.userAuthenticated.num)}},{key:"getQuestionnaireProfileU",value:function(){return this.htttpClient.get(this.hostTest+"/listQuestion/")}},{key:"saveProfilU",value:function(e){return this.htttpClient.post(this.hostTest+"/saveClientRa/",e.valueOf())}},{key:"getResultatProfileU",value:function(){return this.htttpClient.get(this.hostTest+"/questionClient/"+this.userConnect.userAuthenticated.num)}},{key:"getRestitusionProfilU",value:function(){return this.htttpClient.get(this.hostTest+"/restitusionAll/")}},{key:"getRestitusionProfilUByPosAndDim",value:function(e,t){return this.htttpClient.get(this.hostTest+"/restitusionByDimAndPos/"+e+"/"+t)}},{key:"saveCompetence",value:function(e){return this.htttpClient.post(this.hostTest+"/saveListCompetences/",e.valueOf())}},{key:"getCompetence",value:function(){return this.htttpClient.get(this.hostTest+"/listCompetences/")}},{key:"getCompetenceById",value:function(e){return this.htttpClient.get(this.hostTest+"/getCompetenceById/"+e)}},{key:"getCompetenceByCompetence",value:function(e){return this.htttpClient.get(this.hostTest+"/getCompetenceByCompetence/"+e)}},{key:"saveCompetenceClient",value:function(e){return this.htttpClient.post(this.hostTest+"/saveListCompetencesClient/",e.valueOf())}},{key:"getCompetenceClient",value:function(){return this.htttpClient.get(this.hostTest+"/getCompetenceClientByIdClient/"+this.userConnect.userAuthenticated.num)}}]),e}();return e.\u0275fac=function(t){return new(t||e)(i.cc(r.a),i.cc(a.a),i.cc(o.a))},e.\u0275prov=i.Nb({token:e,factory:e.\u0275fac,providedIn:"root"}),e}()},MutI:function(e,t,n){"use strict";n.d(t,"a",(function(){return c}));var i=n("ofXK"),r=n("fXoL"),a=n("FKr1");n("8LU1"),n("XNiG"),n("1G5W"),n("JX91"),n("u47x"),n("0EQZ"),n("FtGj"),n("3Pt+");var o,s,l=((s=function e(){_classCallCheck(this,e)}).\u0275mod=r.Pb({type:s}),s.\u0275inj=r.Ob({factory:function(e){return new(e||s)},imports:[[a.f],a.f]}),s),c=((o=function e(){_classCallCheck(this,e)}).\u0275mod=r.Pb({type:o}),o.\u0275inj=r.Ob({factory:function(e){return new(e||o)},imports:[[a.h,a.o,a.f,a.m,i.b],a.h,a.f,a.m,l]}),o)},d3UM:function(e,t,n){"use strict";n.d(t,"a",(function(){return K})),n.d(t,"b",(function(){return Y}));var i=n("rDax"),r=n("ofXK"),a=n("fXoL"),o=n("FKr1"),s=n("kmnG"),l=n("vxfF"),c=n("u47x"),u=n("8LU1"),h=n("0EQZ"),p=n("FtGj"),d=n("XNiG"),f=n("NXyV"),g=n("VRyK"),_=n("JX91"),m=n("eIep"),y=n("IzEk"),v=n("pLZG"),b=n("lJxs"),C=n("/uUt"),O=n("1G5W"),k=n("R0Ic"),w=n("cH1L"),I=n("3Pt+"),S=["trigger"],j=["panel"];function x(e,t){if(1&e&&(a.Xb(0,"span",8),a.Jc(1),a.Wb()),2&e){var n=a.kc();a.Db(1),a.Kc(n.placeholder||"\xa0")}}function M(e,t){if(1&e&&(a.Xb(0,"span"),a.Jc(1),a.Wb()),2&e){var n=a.kc(2);a.Db(1),a.Kc(n.triggerValue||"\xa0")}}function R(e,t){1&e&&a.lc(0,0,["*ngSwitchCase","true"])}function A(e,t){if(1&e&&(a.Xb(0,"span",9),a.Hc(1,M,2,1,"span",10),a.Hc(2,R,1,0,void 0,11),a.Wb()),2&e){var n=a.kc();a.nc("ngSwitch",!!n.customTrigger),a.Db(2),a.nc("ngSwitchCase",!0)}}function D(e,t){if(1&e){var n=a.Yb();a.Xb(0,"div",12),a.Xb(1,"div",13,14),a.gc("@transformPanel.done",(function(e){return a.Ac(n),a.kc()._panelDoneAnimatingStream.next(e.toState)}))("keydown",(function(e){return a.Ac(n),a.kc()._handleKeydown(e)})),a.lc(3,1),a.Wb(),a.Wb()}if(2&e){var i=a.kc();a.nc("@transformPanelWrap",void 0),a.Db(1),a.Gb("mat-select-panel ",i._getPanelTheme(),""),a.Gc("transform-origin",i._transformOrigin)("font-size",i._triggerFontSize,"px"),a.nc("ngClass",i.panelClass)("@transformPanel",i.multiple?"showing-multiple":"showing"),a.Eb("id",i.id+"-panel")}}var T=[[["mat-select-trigger"]],"*"],P=["mat-select-trigger","*"],F={transformPanelWrap:Object(k.m)("transformPanelWrap",[Object(k.l)("* => void",Object(k.h)("@transformPanel",[Object(k.f)()],{optional:!0}))]),transformPanel:Object(k.m)("transformPanel",[Object(k.j)("void",Object(k.k)({transform:"scaleY(0.8)",minWidth:"100%",opacity:0})),Object(k.j)("showing",Object(k.k)({opacity:1,minWidth:"calc(100% + 32px)",transform:"scaleY(1)"})),Object(k.j)("showing-multiple",Object(k.k)({opacity:1,minWidth:"calc(100% + 64px)",transform:"scaleY(1)"})),Object(k.l)("void => *",Object(k.e)("120ms cubic-bezier(0, 0, 0.2, 1)")),Object(k.l)("* => void",Object(k.e)("100ms 25ms linear",Object(k.k)({opacity:0})))])},L=0,E=new a.r("mat-select-scroll-strategy"),V=new a.r("MAT_SELECT_CONFIG"),W={provide:E,deps:[i.c],useFactory:function(e){return function(){return e.scrollStrategies.reposition()}}},z=function e(t,n){_classCallCheck(this,e),this.source=t,this.value=n},X=Object(o.s)(Object(o.w)(Object(o.t)(Object(o.u)((function e(t,n,i,r,a){_classCallCheck(this,e),this._elementRef=t,this._defaultErrorStateMatcher=n,this._parentForm=i,this._parentFormGroup=r,this.ngControl=a}))))),B=function(){var e=function e(){_classCallCheck(this,e)};return e.\u0275fac=function(t){return new(t||e)},e.\u0275dir=a.Mb({type:e,selectors:[["mat-select-trigger"]]}),e}(),K=function(){var e=function(e){_inherits(n,e);var t=_createSuper(n);function n(e,i,r,o,s,l,c,u,h,p,C,O,k,w){var I;return _classCallCheck(this,n),(I=t.call(this,s,o,c,u,p))._viewportRuler=e,I._changeDetectorRef=i,I._ngZone=r,I._dir=l,I._parentFormField=h,I.ngControl=p,I._liveAnnouncer=k,I._panelOpen=!1,I._required=!1,I._scrollTop=0,I._multiple=!1,I._compareWith=function(e,t){return e===t},I._uid="mat-select-".concat(L++),I._destroy=new d.a,I._triggerFontSize=0,I._onChange=function(){},I._onTouched=function(){},I._optionIds="",I._transformOrigin="top",I._panelDoneAnimatingStream=new d.a,I._offsetY=0,I._positions=[{originX:"start",originY:"top",overlayX:"start",overlayY:"top"},{originX:"start",originY:"bottom",overlayX:"start",overlayY:"bottom"}],I._disableOptionCentering=!1,I._focused=!1,I.controlType="mat-select",I.ariaLabel="",I.optionSelectionChanges=Object(f.a)((function(){var e=I.options;return e?e.changes.pipe(Object(_.a)(e),Object(m.a)((function(){return Object(g.a).apply(void 0,_toConsumableArray(e.map((function(e){return e.onSelectionChange}))))}))):I._ngZone.onStable.asObservable().pipe(Object(y.a)(1),Object(m.a)((function(){return I.optionSelectionChanges})))})),I.openedChange=new a.o,I._openedStream=I.openedChange.pipe(Object(v.a)((function(e){return e})),Object(b.a)((function(){}))),I._closedStream=I.openedChange.pipe(Object(v.a)((function(e){return!e})),Object(b.a)((function(){}))),I.selectionChange=new a.o,I.valueChange=new a.o,I.ngControl&&(I.ngControl.valueAccessor=_assertThisInitialized(I)),I._scrollStrategyFactory=O,I._scrollStrategy=I._scrollStrategyFactory(),I.tabIndex=parseInt(C)||0,I.id=I.id,w&&(null!=w.disableOptionCentering&&(I.disableOptionCentering=w.disableOptionCentering),null!=w.typeaheadDebounceInterval&&(I.typeaheadDebounceInterval=w.typeaheadDebounceInterval)),I}return _createClass(n,[{key:"ngOnInit",value:function(){var e=this;this._selectionModel=new h.c(this.multiple),this.stateChanges.next(),this._panelDoneAnimatingStream.pipe(Object(C.a)(),Object(O.a)(this._destroy)).subscribe((function(){e.panelOpen?(e._scrollTop=0,e.openedChange.emit(!0)):(e.openedChange.emit(!1),e.overlayDir.offsetX=0,e._changeDetectorRef.markForCheck())})),this._viewportRuler.change().pipe(Object(O.a)(this._destroy)).subscribe((function(){e._panelOpen&&(e._triggerRect=e.trigger.nativeElement.getBoundingClientRect(),e._changeDetectorRef.markForCheck())}))}},{key:"ngAfterContentInit",value:function(){var e=this;this._initKeyManager(),this._selectionModel.changed.pipe(Object(O.a)(this._destroy)).subscribe((function(e){e.added.forEach((function(e){return e.select()})),e.removed.forEach((function(e){return e.deselect()}))})),this.options.changes.pipe(Object(_.a)(null),Object(O.a)(this._destroy)).subscribe((function(){e._resetOptions(),e._initializeSelection()}))}},{key:"ngDoCheck",value:function(){this.ngControl&&this.updateErrorState()}},{key:"ngOnChanges",value:function(e){e.disabled&&this.stateChanges.next(),e.typeaheadDebounceInterval&&this._keyManager&&this._keyManager.withTypeAhead(this._typeaheadDebounceInterval)}},{key:"ngOnDestroy",value:function(){this._destroy.next(),this._destroy.complete(),this.stateChanges.complete()}},{key:"toggle",value:function(){this.panelOpen?this.close():this.open()}},{key:"open",value:function(){var e=this;!this.disabled&&this.options&&this.options.length&&!this._panelOpen&&(this._triggerRect=this.trigger.nativeElement.getBoundingClientRect(),this._triggerFontSize=parseInt(getComputedStyle(this.trigger.nativeElement).fontSize||"0"),this._panelOpen=!0,this._keyManager.withHorizontalOrientation(null),this._calculateOverlayPosition(),this._highlightCorrectOption(),this._changeDetectorRef.markForCheck(),this._ngZone.onStable.asObservable().pipe(Object(y.a)(1)).subscribe((function(){e._triggerFontSize&&e.overlayDir.overlayRef&&e.overlayDir.overlayRef.overlayElement&&(e.overlayDir.overlayRef.overlayElement.style.fontSize="".concat(e._triggerFontSize,"px"))})))}},{key:"close",value:function(){this._panelOpen&&(this._panelOpen=!1,this._keyManager.withHorizontalOrientation(this._isRtl()?"rtl":"ltr"),this._changeDetectorRef.markForCheck(),this._onTouched())}},{key:"writeValue",value:function(e){this.options&&this._setSelectionByValue(e)}},{key:"registerOnChange",value:function(e){this._onChange=e}},{key:"registerOnTouched",value:function(e){this._onTouched=e}},{key:"setDisabledState",value:function(e){this.disabled=e,this._changeDetectorRef.markForCheck(),this.stateChanges.next()}},{key:"_isRtl",value:function(){return!!this._dir&&"rtl"===this._dir.value}},{key:"_handleKeydown",value:function(e){this.disabled||(this.panelOpen?this._handleOpenKeydown(e):this._handleClosedKeydown(e))}},{key:"_handleClosedKeydown",value:function(e){var t=e.keyCode,n=t===p.b||t===p.l||t===p.g||t===p.i,i=t===p.d||t===p.j,r=this._keyManager;if(!r.isTyping()&&i&&!Object(p.o)(e)||(this.multiple||e.altKey)&&n)e.preventDefault(),this.open();else if(!this.multiple){var a=this.selected;t===p.f||t===p.c?(t===p.f?r.setFirstItemActive():r.setLastItemActive(),e.preventDefault()):r.onKeydown(e);var o=this.selected;o&&a!==o&&this._liveAnnouncer.announce(o.viewValue,1e4)}}},{key:"_handleOpenKeydown",value:function(e){var t=this._keyManager,n=e.keyCode,i=n===p.b||n===p.l,r=t.isTyping();if(n===p.f||n===p.c)e.preventDefault(),n===p.f?t.setFirstItemActive():t.setLastItemActive();else if(i&&e.altKey)e.preventDefault(),this.close();else if(r||n!==p.d&&n!==p.j||!t.activeItem||Object(p.o)(e))if(!r&&this._multiple&&n===p.a&&e.ctrlKey){e.preventDefault();var a=this.options.some((function(e){return!e.disabled&&!e.selected}));this.options.forEach((function(e){e.disabled||(a?e.select():e.deselect())}))}else{var o=t.activeItemIndex;t.onKeydown(e),this._multiple&&i&&e.shiftKey&&t.activeItem&&t.activeItemIndex!==o&&t.activeItem._selectViaInteraction()}else e.preventDefault(),t.activeItem._selectViaInteraction()}},{key:"_onFocus",value:function(){this.disabled||(this._focused=!0,this.stateChanges.next())}},{key:"_onBlur",value:function(){this._focused=!1,this.disabled||this.panelOpen||(this._onTouched(),this._changeDetectorRef.markForCheck(),this.stateChanges.next())}},{key:"_onAttached",value:function(){var e=this;this.overlayDir.positionChange.pipe(Object(y.a)(1)).subscribe((function(){e._changeDetectorRef.detectChanges(),e._calculateOverlayOffsetX(),e.panel.nativeElement.scrollTop=e._scrollTop}))}},{key:"_getPanelTheme",value:function(){return this._parentFormField?"mat-".concat(this._parentFormField.color):""}},{key:"_initializeSelection",value:function(){var e=this;Promise.resolve().then((function(){e._setSelectionByValue(e.ngControl?e.ngControl.value:e._value),e.stateChanges.next()}))}},{key:"_setSelectionByValue",value:function(e){var t=this;if(this.multiple&&e){if(!Array.isArray(e))throw Error("Value must be an array in multiple-selection mode.");this._selectionModel.clear(),e.forEach((function(e){return t._selectValue(e)})),this._sortValues()}else{this._selectionModel.clear();var n=this._selectValue(e);n?this._keyManager.setActiveItem(n):this.panelOpen||this._keyManager.setActiveItem(-1)}this._changeDetectorRef.markForCheck()}},{key:"_selectValue",value:function(e){var t=this,n=this.options.find((function(n){try{return null!=n.value&&t._compareWith(n.value,e)}catch(i){return Object(a.X)()&&console.warn(i),!1}}));return n&&this._selectionModel.select(n),n}},{key:"_initKeyManager",value:function(){var e=this;this._keyManager=new c.a(this.options).withTypeAhead(this._typeaheadDebounceInterval).withVerticalOrientation().withHorizontalOrientation(this._isRtl()?"rtl":"ltr").withAllowedModifierKeys(["shiftKey"]),this._keyManager.tabOut.pipe(Object(O.a)(this._destroy)).subscribe((function(){e.panelOpen&&(!e.multiple&&e._keyManager.activeItem&&e._keyManager.activeItem._selectViaInteraction(),e.focus(),e.close())})),this._keyManager.change.pipe(Object(O.a)(this._destroy)).subscribe((function(){e._panelOpen&&e.panel?e._scrollActiveOptionIntoView():e._panelOpen||e.multiple||!e._keyManager.activeItem||e._keyManager.activeItem._selectViaInteraction()}))}},{key:"_resetOptions",value:function(){var e=this,t=Object(g.a)(this.options.changes,this._destroy);this.optionSelectionChanges.pipe(Object(O.a)(t)).subscribe((function(t){e._onSelect(t.source,t.isUserInput),t.isUserInput&&!e.multiple&&e._panelOpen&&(e.close(),e.focus())})),Object(g.a).apply(void 0,_toConsumableArray(this.options.map((function(e){return e._stateChanges})))).pipe(Object(O.a)(t)).subscribe((function(){e._changeDetectorRef.markForCheck(),e.stateChanges.next()})),this._setOptionIds()}},{key:"_onSelect",value:function(e,t){var n=this._selectionModel.isSelected(e);null!=e.value||this._multiple?(n!==e.selected&&(e.selected?this._selectionModel.select(e):this._selectionModel.deselect(e)),t&&this._keyManager.setActiveItem(e),this.multiple&&(this._sortValues(),t&&this.focus())):(e.deselect(),this._selectionModel.clear(),this._propagateChanges(e.value)),n!==this._selectionModel.isSelected(e)&&this._propagateChanges(),this.stateChanges.next()}},{key:"_sortValues",value:function(){var e=this;if(this.multiple){var t=this.options.toArray();this._selectionModel.sort((function(n,i){return e.sortComparator?e.sortComparator(n,i,t):t.indexOf(n)-t.indexOf(i)})),this.stateChanges.next()}}},{key:"_propagateChanges",value:function(e){var t;t=this.multiple?this.selected.map((function(e){return e.value})):this.selected?this.selected.value:e,this._value=t,this.valueChange.emit(t),this._onChange(t),this.selectionChange.emit(new z(this,t)),this._changeDetectorRef.markForCheck()}},{key:"_setOptionIds",value:function(){this._optionIds=this.options.map((function(e){return e.id})).join(" ")}},{key:"_highlightCorrectOption",value:function(){this._keyManager&&(this.empty?this._keyManager.setFirstItemActive():this._keyManager.setActiveItem(this._selectionModel.selected[0]))}},{key:"_scrollActiveOptionIntoView",value:function(){var e=this._keyManager.activeItemIndex||0,t=Object(o.p)(e,this.options,this.optionGroups);this.panel.nativeElement.scrollTop=Object(o.q)(e+t,this._getItemHeight(),this.panel.nativeElement.scrollTop,256)}},{key:"focus",value:function(e){this._elementRef.nativeElement.focus(e)}},{key:"_getOptionIndex",value:function(e){return this.options.reduce((function(t,n,i){return void 0!==t?t:e===n?i:void 0}),void 0)}},{key:"_calculateOverlayPosition",value:function(){var e=this._getItemHeight(),t=this._getItemCount(),n=Math.min(t*e,256),i=t*e-n,r=this.empty?0:this._getOptionIndex(this._selectionModel.selected[0]);r+=Object(o.p)(r,this.options,this.optionGroups);var a=n/2;this._scrollTop=this._calculateOverlayScroll(r,a,i),this._offsetY=this._calculateOverlayOffsetY(r,a,i),this._checkOverlayWithinViewport(i)}},{key:"_calculateOverlayScroll",value:function(e,t,n){var i=this._getItemHeight();return Math.min(Math.max(0,i*e-t+i/2),n)}},{key:"_getAriaLabel",value:function(){return this.ariaLabelledby?null:this.ariaLabel||this.placeholder}},{key:"_getAriaLabelledby",value:function(){return this.ariaLabelledby?this.ariaLabelledby:this._parentFormField&&this._parentFormField._hasFloatingLabel()&&!this._getAriaLabel()&&this._parentFormField._labelId||null}},{key:"_getAriaActiveDescendant",value:function(){return this.panelOpen&&this._keyManager&&this._keyManager.activeItem?this._keyManager.activeItem.id:null}},{key:"_calculateOverlayOffsetX",value:function(){var e,t=this.overlayDir.overlayRef.overlayElement.getBoundingClientRect(),n=this._viewportRuler.getViewportSize(),i=this._isRtl(),r=this.multiple?56:32;if(this.multiple)e=40;else{var a=this._selectionModel.selected[0]||this.options.first;e=a&&a.group?32:16}i||(e*=-1);var o=0-(t.left+e-(i?r:0)),s=t.right+e-n.width+(i?0:r);o>0?e+=o+8:s>0&&(e-=s+8),this.overlayDir.offsetX=Math.round(e),this.overlayDir.overlayRef.updatePosition()}},{key:"_calculateOverlayOffsetY",value:function(e,t,n){var i,r=this._getItemHeight(),a=(r-this._triggerRect.height)/2,o=Math.floor(256/r);return this._disableOptionCentering?0:(i=0===this._scrollTop?e*r:this._scrollTop===n?(e-(this._getItemCount()-o))*r+(r-(this._getItemCount()*r-256)%r):t-r/2,Math.round(-1*i-a))}},{key:"_checkOverlayWithinViewport",value:function(e){var t=this._getItemHeight(),n=this._viewportRuler.getViewportSize(),i=this._triggerRect.top-8,r=n.height-this._triggerRect.bottom-8,a=Math.abs(this._offsetY),o=Math.min(this._getItemCount()*t,256)-a-this._triggerRect.height;o>r?this._adjustPanelUp(o,r):a>i?this._adjustPanelDown(a,i,e):this._transformOrigin=this._getOriginBasedOnOption()}},{key:"_adjustPanelUp",value:function(e,t){var n=Math.round(e-t);this._scrollTop-=n,this._offsetY-=n,this._transformOrigin=this._getOriginBasedOnOption(),this._scrollTop<=0&&(this._scrollTop=0,this._offsetY=0,this._transformOrigin="50% bottom 0px")}},{key:"_adjustPanelDown",value:function(e,t,n){var i=Math.round(e-t);if(this._scrollTop+=i,this._offsetY+=i,this._transformOrigin=this._getOriginBasedOnOption(),this._scrollTop>=n)return this._scrollTop=n,this._offsetY=0,void(this._transformOrigin="50% top 0px")}},{key:"_getOriginBasedOnOption",value:function(){var e=this._getItemHeight(),t=(e-this._triggerRect.height)/2;return"50% ".concat(Math.abs(this._offsetY)-t+e/2,"px 0px")}},{key:"_getItemCount",value:function(){return this.options.length+this.optionGroups.length}},{key:"_getItemHeight",value:function(){return 3*this._triggerFontSize}},{key:"setDescribedByIds",value:function(e){this._ariaDescribedby=e.join(" ")}},{key:"onContainerClick",value:function(){this.focus(),this.open()}},{key:"focused",get:function(){return this._focused||this._panelOpen}},{key:"placeholder",get:function(){return this._placeholder},set:function(e){this._placeholder=e,this.stateChanges.next()}},{key:"required",get:function(){return this._required},set:function(e){this._required=Object(u.c)(e),this.stateChanges.next()}},{key:"multiple",get:function(){return this._multiple},set:function(e){if(this._selectionModel)throw Error("Cannot change `multiple` mode of select after initialization.");this._multiple=Object(u.c)(e)}},{key:"disableOptionCentering",get:function(){return this._disableOptionCentering},set:function(e){this._disableOptionCentering=Object(u.c)(e)}},{key:"compareWith",get:function(){return this._compareWith},set:function(e){if("function"!=typeof e)throw Error("`compareWith` must be a function.");this._compareWith=e,this._selectionModel&&this._initializeSelection()}},{key:"value",get:function(){return this._value},set:function(e){e!==this._value&&(this.writeValue(e),this._value=e)}},{key:"typeaheadDebounceInterval",get:function(){return this._typeaheadDebounceInterval},set:function(e){this._typeaheadDebounceInterval=Object(u.f)(e)}},{key:"id",get:function(){return this._id},set:function(e){this._id=e||this._uid,this.stateChanges.next()}},{key:"panelOpen",get:function(){return this._panelOpen}},{key:"selected",get:function(){return this.multiple?this._selectionModel.selected:this._selectionModel.selected[0]}},{key:"triggerValue",get:function(){if(this.empty)return"";if(this._multiple){var e=this._selectionModel.selected.map((function(e){return e.viewValue}));return this._isRtl()&&e.reverse(),e.join(", ")}return this._selectionModel.selected[0].viewValue}},{key:"empty",get:function(){return!this._selectionModel||this._selectionModel.isEmpty()}},{key:"shouldLabelFloat",get:function(){return this._panelOpen||!this.empty}}]),n}(X);return e.\u0275fac=function(t){return new(t||e)(a.Rb(l.d),a.Rb(a.h),a.Rb(a.A),a.Rb(o.c),a.Rb(a.l),a.Rb(w.b,8),a.Rb(I.p,8),a.Rb(I.i,8),a.Rb(s.a,8),a.Rb(I.m,10),a.dc("tabindex"),a.Rb(E),a.Rb(c.f),a.Rb(V,8))},e.\u0275cmp=a.Lb({type:e,selectors:[["mat-select"]],contentQueries:function(e,t,n){var i;1&e&&(a.Jb(n,B,!0),a.Jb(n,o.j,!0),a.Jb(n,o.i,!0)),2&e&&(a.xc(i=a.hc())&&(t.customTrigger=i.first),a.xc(i=a.hc())&&(t.options=i),a.xc(i=a.hc())&&(t.optionGroups=i))},viewQuery:function(e,t){var n;1&e&&(a.Oc(S,!0),a.Oc(j,!0),a.Oc(i.a,!0)),2&e&&(a.xc(n=a.hc())&&(t.trigger=n.first),a.xc(n=a.hc())&&(t.panel=n.first),a.xc(n=a.hc())&&(t.overlayDir=n.first))},hostAttrs:["role","listbox",1,"mat-select"],hostVars:19,hostBindings:function(e,t){1&e&&a.gc("keydown",(function(e){return t._handleKeydown(e)}))("focus",(function(){return t._onFocus()}))("blur",(function(){return t._onBlur()})),2&e&&(a.Eb("id",t.id)("tabindex",t.tabIndex)("aria-label",t._getAriaLabel())("aria-labelledby",t._getAriaLabelledby())("aria-required",t.required.toString())("aria-disabled",t.disabled.toString())("aria-invalid",t.errorState)("aria-owns",t.panelOpen?t._optionIds:null)("aria-multiselectable",t.multiple)("aria-describedby",t._ariaDescribedby||null)("aria-activedescendant",t._getAriaActiveDescendant()),a.Hb("mat-select-disabled",t.disabled)("mat-select-invalid",t.errorState)("mat-select-required",t.required)("mat-select-empty",t.empty))},inputs:{disabled:"disabled",disableRipple:"disableRipple",tabIndex:"tabIndex",ariaLabel:["aria-label","ariaLabel"],id:"id",disableOptionCentering:"disableOptionCentering",typeaheadDebounceInterval:"typeaheadDebounceInterval",placeholder:"placeholder",required:"required",multiple:"multiple",compareWith:"compareWith",value:"value",panelClass:"panelClass",ariaLabelledby:["aria-labelledby","ariaLabelledby"],errorStateMatcher:"errorStateMatcher",sortComparator:"sortComparator"},outputs:{openedChange:"openedChange",_openedStream:"opened",_closedStream:"closed",selectionChange:"selectionChange",valueChange:"valueChange"},exportAs:["matSelect"],features:[a.Cb([{provide:s.d,useExisting:e},{provide:o.e,useExisting:e}]),a.Ab,a.Bb],ngContentSelectors:P,decls:9,vars:9,consts:[["cdk-overlay-origin","","aria-hidden","true",1,"mat-select-trigger",3,"click"],["origin","cdkOverlayOrigin","trigger",""],[1,"mat-select-value",3,"ngSwitch"],["class","mat-select-placeholder",4,"ngSwitchCase"],["class","mat-select-value-text",3,"ngSwitch",4,"ngSwitchCase"],[1,"mat-select-arrow-wrapper"],[1,"mat-select-arrow"],["cdk-connected-overlay","","cdkConnectedOverlayLockPosition","","cdkConnectedOverlayHasBackdrop","","cdkConnectedOverlayBackdropClass","cdk-overlay-transparent-backdrop",3,"cdkConnectedOverlayScrollStrategy","cdkConnectedOverlayOrigin","cdkConnectedOverlayOpen","cdkConnectedOverlayPositions","cdkConnectedOverlayMinWidth","cdkConnectedOverlayOffsetY","backdropClick","attach","detach"],[1,"mat-select-placeholder"],[1,"mat-select-value-text",3,"ngSwitch"],[4,"ngSwitchDefault"],[4,"ngSwitchCase"],[1,"mat-select-panel-wrap"],[3,"ngClass","keydown"],["panel",""]],template:function(e,t){if(1&e&&(a.mc(T),a.Xb(0,"div",0,1),a.gc("click",(function(){return t.toggle()})),a.Xb(3,"div",2),a.Hc(4,x,2,1,"span",3),a.Hc(5,A,3,2,"span",4),a.Wb(),a.Xb(6,"div",5),a.Sb(7,"div",6),a.Wb(),a.Wb(),a.Hc(8,D,4,11,"ng-template",7),a.gc("backdropClick",(function(){return t.close()}))("attach",(function(){return t._onAttached()}))("detach",(function(){return t.close()}))),2&e){var n=a.yc(1);a.Db(3),a.nc("ngSwitch",t.empty),a.Db(1),a.nc("ngSwitchCase",!0),a.Db(1),a.nc("ngSwitchCase",!1),a.Db(3),a.nc("cdkConnectedOverlayScrollStrategy",t._scrollStrategy)("cdkConnectedOverlayOrigin",n)("cdkConnectedOverlayOpen",t.panelOpen)("cdkConnectedOverlayPositions",t._positions)("cdkConnectedOverlayMinWidth",null==t._triggerRect?null:t._triggerRect.width)("cdkConnectedOverlayOffsetY",t._offsetY)}},directives:[i.b,r.l,r.m,i.a,r.n,r.h],styles:[".mat-select{display:inline-block;width:100%;outline:none}.mat-select-trigger{display:inline-table;cursor:pointer;position:relative;box-sizing:border-box}.mat-select-disabled .mat-select-trigger{-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;cursor:default}.mat-select-value{display:table-cell;max-width:0;width:100%;overflow:hidden;text-overflow:ellipsis;white-space:nowrap}.mat-select-value-text{white-space:nowrap;overflow:hidden;text-overflow:ellipsis}.mat-select-arrow-wrapper{display:table-cell;vertical-align:middle}.mat-form-field-appearance-fill .mat-select-arrow-wrapper{transform:translateY(-50%)}.mat-form-field-appearance-outline .mat-select-arrow-wrapper{transform:translateY(-25%)}.mat-form-field-appearance-standard.mat-form-field-has-label .mat-select:not(.mat-select-empty) .mat-select-arrow-wrapper{transform:translateY(-50%)}.mat-form-field-appearance-standard .mat-select.mat-select-empty .mat-select-arrow-wrapper{transition:transform 400ms cubic-bezier(0.25, 0.8, 0.25, 1)}._mat-animation-noopable.mat-form-field-appearance-standard .mat-select.mat-select-empty .mat-select-arrow-wrapper{transition:none}.mat-select-arrow{width:0;height:0;border-left:5px solid transparent;border-right:5px solid transparent;border-top:5px solid;margin:0 4px}.mat-select-panel-wrap{flex-basis:100%}.mat-select-panel{min-width:112px;max-width:280px;overflow:auto;-webkit-overflow-scrolling:touch;padding-top:0;padding-bottom:0;max-height:256px;min-width:100%;border-radius:4px}.cdk-high-contrast-active .mat-select-panel{outline:solid 1px}.mat-select-panel .mat-optgroup-label,.mat-select-panel .mat-option{font-size:inherit;line-height:3em;height:3em}.mat-form-field-type-mat-select:not(.mat-form-field-disabled) .mat-form-field-flex{cursor:pointer}.mat-form-field-type-mat-select .mat-form-field-label{width:calc(100% - 18px)}.mat-select-placeholder{transition:color 400ms 133.3333333333ms cubic-bezier(0.25, 0.8, 0.25, 1)}._mat-animation-noopable .mat-select-placeholder{transition:none}.mat-form-field-hide-placeholder .mat-select-placeholder{color:transparent;-webkit-text-fill-color:transparent;transition:none;display:block}\n"],encapsulation:2,data:{animation:[F.transformPanelWrap,F.transformPanel]},changeDetection:0}),e}(),Y=function(){var e=function e(){_classCallCheck(this,e)};return e.\u0275mod=a.Pb({type:e}),e.\u0275inj=a.Ob({factory:function(t){return new(t||e)},providers:[W],imports:[[r.b,i.f,o.k,o.f],l.a,s.e,o.k,o.f]}),e}()}}]);