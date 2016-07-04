
/*
 * jQuery optionTree Plugin
 * version: 1.0.1
 * @requires jQuery v1.2 or later
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 *
 * @version $Id: jqueryOptionTree-1.2.2.5-aramark-2.js,v 1.2 2015/06/09 15:10:36 adm-mcrowley Exp $
 * @author  Krzysztof Kotowicz <kkotowicz at gmail dot com>
 */

/**
 * Converts passed JSON option tree into dynamically created <select> elements
 * allowing you to choose nested options.
 * 
 * @param String
 *            tree options tree
 * @param array
 *            options additional options (optional)
 */
(function($) {
	var optionFoundCategorySelectBoxLevel = 0; // Level that selected
	// option is found.
	var firstCategorySelectBoxKey = ""; // Name of first parent Category
	// to the found option.
	var secondCategorySelectBoxKey = ""; // Name of second parent
	// Category to the found option.
	var thirdCategorySelectBoxKey = ""; // Name of third parent Category
	// to the found option.
	var forthCategorySelectBoxKey = ""; // Name of forth parent Category
	// to the found option.
	var foundCategoryOption = false; // The value of the preSelected
	// Category option was found ok.
	var optionFoundLocationSelectBoxLevel = 0; // Level that selected option is
	// found.
	var firstLocationSelectBoxKey = ""; // Name of first parent Location
	// to the found option.
	var secondLocationSelectBoxKey = ""; // Name of second parent
	// Location to the found option.
	var thirdLocationSelectBoxKey = ""; // Name of third parent Location
	// to the found option.
	var forthLocationSelectBoxKey = ""; // Name of forth parent Location
	// to the found option.
	var foundLocationOption = false; // The value of the preSelected
	// Location option was found ok.
	var atLoadTime = false; // If at loading time then when
	// the change event is manually
	// triggered there's no need to
	// parse through the select box
	// looking for selected option.
	var ccdPlannedPriority = "P4+";
	var restPlannedPriority = "Planned";
	var plannedPriority = ccdPlannedPriority;

	$.fn.optionTree = function(tree, options) {

		/*
		 * Example of preselect : {'LOCATION' : 1002}, But looking at value
		 * change in google chromes dev inspector there seems to be an problem
		 * with preselect. When another leaf is chosen and the parent dropdown
		 * of the preselect item is chosen again the hidden input value doesn't
		 * change to the value of the preselected item.
		 */
		options = $.extend( {
			choose : 'Choose...',
			preselect : {},
			select_class : '',
			leaf_class : 'final',
			empty_value : ''
		}, options || {});

		var cleanName = function(name) {
			return name.replace(/_*$/, '');
		};
		
		var removeNested = function(name) {
			$("select[name^='" + name + "']").remove();
		};

		var setValue = function(name, value) {
			$("input[name='" + cleanName(name) + "']").val(value).change();
		};

		// Check if a var is defined.
		function isSet(varname) {
			return (typeof (varname) != 'undefined');
		}

		function doPriorityChange() {
			if (isSet(window.priorityResolutionDates)
					&& isSet($("#TICKET_PRIORITY").val())
					&& isSet($("span#slaResolutionDateSpanId").val())) {
				$("span#slaResolutionDateSpanId").text(
						priorityResolutionDates[$("#TICKET_PRIORITY").val()]);
			}
			doRequiredDateVisibility();
		}

		if (isSet(window.priorityResolutionDates)
				&& isSet($("#TICKET_PRIORITY").val())) {
			$("#TICKET_PRIORITY").change(function() {
				doPriorityChange();
			});
		}

		if (isSet(window.priorityResolutionDates)
				&& isSet($("#TICKET_PRIORITY").val())) {
			$("#TICKET_PRIORITY").keyup(function() {
				doPriorityChange();
			});
		}

		function doRequiredDateVisibility() {
			if ($("#TICKET_PRIORITY option:selected").text() == "P4+"){
				$("#RequiredDateSpan").attr("style", "display: block;");
			}
			else {
				$("#RequiredDateSpan").attr("style", "display: none;");
			}
		}

		function doTypeChange() {
			if (($("#TICKET_TYPE").val() == "Query/Request")
					|| ($("#TICKET_TYPE").val() == "Building Defect")
					|| ($("#TICKET_TYPE").val() == "Complaint")
					|| ($("#TICKET_TYPE").val() == "ISO")
					|| ($("#TICKET_TYPE").val() == "PPM Follow-up")) {
				$("#TICKET_PRIORITY").val("107");
				$("span#slaResolutionDateSpanId").text(
						priorityResolutionDates[$("#TICKET_PRIORITY").val()]);
			}
			doRequiredDateVisibility();
		}

		if (isSet($("#TICKET_TYPE").val())) {
			$("#TICKET_TYPE").change(function() {
				doTypeChange();
			});
		}

		if (isSet($("#TICKET_TYPE").val())) {
			$("#TICKET_TYPE").keyup(function() {
				doTypeChange();
			});
		}

		return this.each(function() {

			var name = $(this).attr('name') + "_";
			var optionFoundSelectBoxLevel = 0; // Level that selected
				// option is found.
				var firstSelectBoxKey = ""; // Name of first parent to
				// the found option.
				var secondSelectBoxKey = ""; // Name of second parent to
				// the found option.
				var thirdSelectBoxKey = ""; // Name of third parent to
				// the found option.
				var forthSelectBoxKey = ""; // Name of forth parent to
				// the found option.
				var foundOption = false; // The value of the
				// preSelected option was
				// found ok.
				var categorySelectBox = false; // Currently dealing with
				// the category select box.
				var locationSelectBox = false; // Currently dealing with
				// the location select box.
				var selectboxLevel = (name.split(/_/g).length) - 1; // Count
				// number
				// of _
				// characters.

				// remove all dynamic options of lower levels
				removeNested(name);

				if (typeof tree == "object") { // many options exists for
					// current nesting level

					// create select element with all the options
					// and bind onchange event to recursively call this function

					if (name.match("^" + "CATEGORY") == "CATEGORY") { // If
						// the
						// start
						// of the name
						// is CATEGORY
						categorySelectBox = true;
						locationSelectBox = false;
					} else if (name.match("^" + "LOCATION") == "LOCATION") { // If
						// the
						// start
						// of
						// the
						// name
						// is
						// LOCATION
						locationSelectBox = true;
						categorySelectBox = false;
					}
					$
							.each(tree, function(key, value) {
								if (foundOption || atLoadTime) // Includes a
										// check for
									// atLoadTime so that
									// needless parsing is
									// performed when the change
									// event is manually
									// triggered during the
									// $(window).load(function().
									return false; // Break out of each loop.
								optionFoundSelectBoxLevel = 1;
								firstSelectBoxKey = key;
								if ((categorySelectBox && value == preSelectedCategory)
										|| (locationSelectBox && value == preSelectedLocation)
										|| (locationSelectBox && 'undefined'!=typeof(option_tree_value_map) && option_tree_value_map[key] == preSelectedLocation)) {
									foundOption = true;
									return false;
								}
								if (typeof value == "object") {
									$
											.each(
													value,
													function(key, value) {
														if (foundOption)
															return false;
														optionFoundSelectBoxLevel = 2;
														secondSelectBoxKey = key;
														if ((categorySelectBox && value == preSelectedCategory)
																|| (locationSelectBox && value == preSelectedLocation)
																|| (locationSelectBox && 'undefined'!=typeof(option_tree_value_map) && option_tree_value_map[key] == preSelectedLocation)) {
															foundOption = true;
															return false;
														}
														if (typeof value == "object") {
															$
																	.each(
																			value,
																			function(
																					key,
																					value) {
																				if (foundOption)
																					return false;
																				optionFoundSelectBoxLevel = 3;
																				thirdSelectBoxKey = key;
																				if ((categorySelectBox && value == preSelectedCategory)
																						|| (locationSelectBox && value == preSelectedLocation)
																						|| (locationSelectBox && 'undefined'!=typeof(option_tree_value_map) && option_tree_value_map[key] == preSelectedLocation)) {
																					foundOption = true;
																					return false;
																				}
																				if (typeof value == "object") {
																					$
																							.each(
																									value,
																									function(
																											key,
																											value) {
																										if (foundOption)
																											return false;
																										optionFoundSelectBoxLevel = 4;
																										forthSelectBoxKey = key;
																										if ((categorySelectBox && value == preSelectedCategory)
																												|| (locationSelectBox && value == preSelectedLocation)
																												|| (locationSelectBox && 'undefined'!=typeof(option_tree_value_map) && option_tree_value_map[key] == preSelectedLocation)) {
																											foundOption = true;
																											return false;
																										}
																									});
																					if (!foundOption) {
																						 // Not found at forth level yet yet so reset vars.
																						forthSelectBoxKey = "";
																						optionFoundSelectBoxLevel = 3;
																					}
																				}
																			});
															if (!foundOption) {
																// Not found at third level yet, so reset vars.
																thirdSelectBoxKey = "";
																optionFoundSelectBoxLevel = 2;
															}
														}
													});
									if (!foundOption) {
										// Not found at second level yet yet so
										// reset vars.
										secondSelectBoxKey = "";
										optionFoundSelectBoxLevel = 1;
									}
								}
							});
					if (foundOption && !atLoadTime) { // If at loading time
						// then
						// when the change event is
						// manually
						// triggered there's no need
						// to parse through the
						// select box
						// looking for selected
						// option.
						if (name.match("^" + "CATEGORY") == "CATEGORY") {
							firstCategorySelectBoxKey = firstSelectBoxKey;
							secondCategorySelectBoxKey = secondSelectBoxKey;
							thirdCategorySelectBoxKey = thirdSelectBoxKey;
							forthCategorySelectBoxKey = forthSelectBoxKey;
							foundCategoryOption = foundOption;
							optionFoundCategorySelectBoxLevel = optionFoundSelectBoxLevel;
						}
						if (name.match("^" + "LOCATION") == "LOCATION") {
							firstLocationSelectBoxKey = firstSelectBoxKey;
							secondLocationSelectBoxKey = secondSelectBoxKey;
							thirdLocationSelectBoxKey = thirdSelectBoxKey;
							forthLocationSelectBoxKey = forthSelectBoxKey;
							foundLocationOption = foundOption;
							optionFoundLocationSelectBoxLevel = optionFoundSelectBoxLevel;
						}
					} else {
						if (!atLoadTime) {
							// Not found at first level yet yet so reset vars.
							firstSelectBoxKey = "";
							optionFoundSelectBoxLevel = 0;
						}
					}

					var $select = $("<select>")
							.attr('name', name)
							.attr('id', name)
							.change(
									function() {
										if (this.options[this.selectedIndex].value != '') {
											$(this)
													.optionTree(
															tree[this.options[this.selectedIndex].value],
															options);
										} else {
											selectboxLevel = (name.split(/_/g).length) - 1; // Count
											// number
											// of _
											// characters.
											removeNested(name + '_');
											setValue(name, options.empty_value);
										}
										// 638
										if(window.getOptionTreeValue){getOptionTreeValue(this.options[this.selectedIndex].value, name);}
									});
					
					// $select.css("width", "15%");
					if ($(this).is('input'))
						$select.insertBefore(this);
					else
						$select.insertAfter(this);

					if (options.select_class)
						$select.addClass(options.select_class);

					if (name.match("^" + "CATEGORY") == "CATEGORY") {
						// Check has categoryLevels been defined.
						// Also check that the number of labels given is >= the
						// current level. Otherwise lack of a label gives an
						// error.
						if ((isSet(window.categoryLevels))
								&& (categoryLevels.categoryLevels.length >= selectboxLevel)) {
							$("<option>")
									.append(
											categoryLevels.categoryLevels[selectboxLevel - 1])
									.val('').appendTo($select);
						}
					} else if (name.match("^" + "LOCATION") == "LOCATION") {
						if ((isSet(window.locationLevels))
								&& (locationLevels.locationLevels.length >= selectboxLevel)) {
							$("<option>")
									.append(
											locationLevels.locationLevels[selectboxLevel - 1])
									.val('').appendTo($select);
						}
					}
					$.each(tree, function(k, v) {
						var o = $("<option>").append(k).attr('value', k);
						var clean = cleanName(name);
						if (options.leaf_class && typeof v != 'object') // this
								// option is
							// a leaf
							// node
							o.addClass(options.leaf_class);

						o.appendTo($select);
						if (options.preselect && options.preselect[clean]
								&& options.preselect[clean] == v) {
							o.get(0).selected = true;
							$select.change();
						}
					});

				} else { // single option is selected by the user (function
					// called via onchange event())
					setValue(name, tree);
				}
			});
	};

	$(window).load(function() {
		atLoadTime = true; // If at loading time then when the change event is
			// manually
			// triggered there's no need to parse through the
			// select box
			// looking for selected option.
			if (foundCategoryOption) {
				if ($("#CATEGORY_ option:selected").length) { // If any option
					// of
					// the category
					// select box is
					// currently set to
					// selected (i.e. a
					// pre selection).
					if (optionFoundCategorySelectBoxLevel >= 1) {
						$(
								"#CATEGORY_ option[value="
										+ firstCategorySelectBoxKey + "]")
								.attr("selected", "selected");
						$(
								"#CATEGORY_ option[value="
										+ firstCategorySelectBoxKey + "]")
								.trigger('change');
					}
					if (optionFoundCategorySelectBoxLevel >= 2) {
						$(
								"#CATEGORY__ option[value="
										+ secondCategorySelectBoxKey + "]")
								.attr("selected", "selected");
						$(
								"#CATEGORY__ option[value="
										+ secondCategorySelectBoxKey + "]")
								.trigger('change');
					}
					if (optionFoundCategorySelectBoxLevel >= 3) {
						$(
								"#CATEGORY___ option[value="
										+ thirdCategorySelectBoxKey + "]")
								.attr("selected", "selected");
						$(
								"#CATEGORY___ option[value="
										+ thirdCategorySelectBoxKey + "]")
								.trigger('change');
					}
					if (optionFoundCategorySelectBoxLevel >= 4) {
						$(
								"#CATEGORY____ option[value="
										+ forthCategorySelectBoxKey + "]")
								.attr("selected", "selected");
						$(
								"#CATEGORY____ option[value="
										+ forthCategorySelectBoxKey + "]")
								.trigger('change');
					}
				}
			}
			if (foundLocationOption) {
				
				var stripQuote = function(Quote) {
					return Quote.replace(/\'/, '\\\'');
				};
				
				if ($("#LOCATION_ option:selected").length) { // If any option
					// of
					// the location
					// select box is
					// currently set to
					// selected (i.e. a
					// pre selection).
					if (optionFoundLocationSelectBoxLevel >= 1) {
						$(
								"#LOCATION_ option[value='"
										+ stripQuote(firstLocationSelectBoxKey) + "']")
								.attr("selected", "selected");
						$(
								"#LOCATION_ option[value='"
										+ stripQuote(firstLocationSelectBoxKey) + "']")
								.trigger('change');
					}
					if (optionFoundLocationSelectBoxLevel >= 2) {
						$(
								"#LOCATION__ option[value='"
										+ stripQuote(secondLocationSelectBoxKey) + "']")
								.attr("selected", "selected");
						$(
								"#LOCATION__ option[value='"
										+ stripQuote(secondLocationSelectBoxKey) + "']")
								.trigger('change');
					}
					if (optionFoundLocationSelectBoxLevel >= 3) {
						$(
								"#LOCATION___ option[value='"
										+ stripQuote(thirdLocationSelectBoxKey) + "']")
								.attr("selected", "selected");
						$(
								"#LOCATION___ option[value='"
										+ stripQuote(thirdLocationSelectBoxKey) + "']")
								.trigger('change');
					}
					if (optionFoundLocationSelectBoxLevel >= 4) {
						$(
								"#LOCATION____ option[value='"
										+ stripQuote(forthLocationSelectBoxKey) + "']")
								.attr("selected", "selected");
						$(
								"#LOCATION____ option[value='"
										+ stripQuote(forthLocationSelectBoxKey) + "']")
								.trigger('change');
					}
				}
			}
		});

})(jQuery);
