/**
 * 
 */

$(document)
		.ready(
				function() {
					$('.delete-recipe')
							.on(
									'click',
									function() {
										/* <![CDATA[ */
										var path = /* [[@{/}]] */'remove';
										/* ]]> */

										var id = $(this).attr('id');

										bootbox
												.confirm({
													message : "Are you sure to remove this recipe? It can't be undone.",
													buttons : {
														cancel : {
															label : '<i class="fa fa-times"></i> Cancel'
														},
														confirm : {
															label : '<i class="fa fa-check"></i> Confirm'
														}
													},
													callback : function(
															confirmed) {
														if (confirmed) {
															$
																	.post(
																			path,
																			{
																				'id' : id
																			},
																			function(
																					res) {
																				location
																						.reload();
																			});
														}
													}
												});
									});

					// $('.checkboxRecipe').click(function () {
					// var id = $(this).attr('id');
					// if(this.checked){
					// recipeIdList.push(id);
					// }
					// else {
					// recipeIdList.splice(recipeIdList.indexOf(id), 1);
					// }
					// })

					$('#deleteSelected')
							.click(
									function() {
										var idList = $('.checkboxRecipe');
										var recipeIdList = [];
										for (var i = 0; i < idList.length; i++) {
											if (idList[i].checked == true) {
												recipeIdList
														.push(idList[i]['id'])
											}
										}

										console.log(recipeIdList);

										/* <![CDATA[ */
										var path = /* [[@{/}]] */'removeList';
										/* ]]> */

										bootbox
												.confirm({
													message : "Are you sure to remove all selected recipes? It can't be undone.",
													buttons : {
														cancel : {
															label : '<i class="fa fa-times"></i> Cancel'
														},
														confirm : {
															label : '<i class="fa fa-check"></i> Confirm'
														}
													},
													callback : function(
															confirmed) {
														if (confirmed) {
															$
																	.ajax({
																		type : 'POST',
																		url : path,
																		data : JSON
																				.stringify(recipeIdList),
																		contentType : "application/json",
																		success : function(
																				res) {
																			console
																					.log(res);
																			location
																					.reload()
																		},
																		error : function(
																				res) {
																			console
																					.log(res);
																			location
																					.reload();
																		}
																	});
														}
													}
												});
									});

					$("#selectAllRecipes").click(function() {
						if ($(this).prop("checked") == true) {
							$(".checkboxRecipe").prop("checked", true);
						} else if ($(this).prop("checked") == false) {
							$(".checkboxRecipe").prop("checked", false);
						}
					})
				});